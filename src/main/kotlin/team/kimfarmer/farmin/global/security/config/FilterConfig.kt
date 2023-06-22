package team.kimfarmer.farmin.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import team.kimfarmer.farmin.global.security.filter.ExceptionFilter
import team.kimfarmer.farmin.global.security.filter.JwtTokenFilter
import team.kimfarmer.farmin.global.security.jwt.JwtTokenProvider

class FilterConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val jwtTokenFilter = JwtTokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}