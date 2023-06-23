package team.kimfarmer.farmin.domain.auth.service.impl

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.auth.domain.repository.RefreshTokenRepository
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto
import team.kimfarmer.farmin.domain.auth.service.SignUpService
import team.kimfarmer.farmin.domain.auth.util.AuthConverter
import team.kimfarmer.farmin.domain.user.domain.repository.UserRepository
import team.kimfarmer.farmin.domain.user.exception.UserAlreadyExistException
import team.kimfarmer.farmin.global.security.jwt.JwtTokenProvider
import team.kimfarmer.farmin.global.security.jwt.properties.TokenTimeProperties

@Service
@Transactional
class SignUpServiceImpl(
        private val userRepository: UserRepository,
        private val authConverter: AuthConverter,
        private val jwtTokenProvider: JwtTokenProvider,
        private val refreshTokenRepository: RefreshTokenRepository,
        private val tokenTimeProperties: TokenTimeProperties,
        private val passwordEncoder: PasswordEncoder
) : SignUpService {
    override fun execute(dto: SignUpDto): SignUpTokenDto {
        checkUserIsExist(dto.id)

        val accessToken = jwtTokenProvider.generateAccessToken(dto.id)
        val refreshToken = jwtTokenProvider.generateRefreshToken(dto.id)
        val accessExp = jwtTokenProvider.accessExpiredTime
        val refreshExp = jwtTokenProvider.refreshExpiredTime

        userRepository.save(authConverter.toEntity(dto, passwordEncoder.encode(dto.password)))
        refreshTokenRepository.save(authConverter.toEntity(refreshToken, dto.id, tokenTimeProperties.refreshTime))
        return SignUpTokenDto(
                accessToken = accessToken,
                refreshToken = refreshToken,
                accessExp = accessExp,
                refreshExp = refreshExp
        )

    }

    private fun checkUserIsExist(id: String) {
        if(userRepository.existsById(id)) {
            throw UserAlreadyExistException()
        }
    }
}