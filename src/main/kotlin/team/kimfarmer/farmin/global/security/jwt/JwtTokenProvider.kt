package team.kimfarmer.farmin.global.security.jwt

import team.kimfarmer.farmin.global.security.auth.AuthDetailsService
import team.kimfarmer.farmin.global.security.exception.ExpiredTokenException
import team.kimfarmer.farmin.global.security.exception.InvalidTokenException
import team.kimfarmer.farmin.global.security.jwt.properties.JwtProperties
import team.kimfarmer.farmin.global.security.jwt.properties.TokenTimeProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key
import java.time.ZonedDateTime
import java.util.*

@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val tokenTimeProperties: TokenTimeProperties,
        private val authDetailsService: AuthDetailsService,
) {
    companion object {
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val TOKEN_PREFIX = "Bearer "
        const val AUTHORITY = "authority"
    }

    val accessExpiredTime: ZonedDateTime
        get() = ZonedDateTime.now().plusSeconds(tokenTimeProperties.accessTime)

    val refreshExpiredTime: ZonedDateTime
        get() = ZonedDateTime.now().plusSeconds(tokenTimeProperties.refreshTime)

    fun generateAccessToken(id: String): String =
        generateToken(id, ACCESS_TYPE, jwtProperties.accessSecret, tokenTimeProperties.accessTime)

    fun generateRefreshToken(id: String): String =
        generateToken(id, REFRESH_TYPE, jwtProperties.refreshSecret, tokenTimeProperties.refreshTime)

    fun resolveToken(req: HttpServletRequest): String? {
        val token = req.getHeader("Authorization") ?: return null
        return parseToken(token)
    }

    fun exactEmailFromRefreshToken(refresh: String): String {
        return getTokenSubject(refresh, jwtProperties.refreshSecret)
    }

    fun exactTypeFromRefreshToken(refresh: String): String =
        getTokenSubject(refresh, jwtProperties.refreshSecret)

    fun authentication(token: String): Authentication {
        val userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.accessSecret))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun parseToken(token: String): String? =
        if (token.startsWith(TOKEN_PREFIX)) token.replace(TOKEN_PREFIX, "") else null

    fun generateToken(id: String, type: String, secret: Key, exp: Long): String {
        val claims = Jwts.claims().setSubject(id)
        claims["type"] = type
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .signWith(secret, SignatureAlgorithm.HS256)
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }

    private fun getTokenBody(token: String, secret: Key): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: Exception) {
            throw InvalidTokenException()
        }
    }

    private fun getTokenSubject(token: String, secret: Key): String =
        getTokenBody(token, secret).subject
}