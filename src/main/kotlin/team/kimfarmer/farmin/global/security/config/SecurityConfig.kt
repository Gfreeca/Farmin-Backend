package team.kimfarmer.farmin.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import team.kimfarmer.farmin.global.security.CustomAuthenticationEntryPoint
import team.kimfarmer.farmin.global.security.jwt.JwtTokenProvider


@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper,
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
         http
                .cors{it.disable()}
                .csrf{it.disable()}
                .formLogin{it.disable()}
                .httpBasic{it.disable()}
                .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}

                .authorizeHttpRequests{
                    it.anyRequest().permitAll()
                }
                .exceptionHandling{
                    it.authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))
                }
        http
                .apply(FilterConfig(jwtTokenProvider, objectMapper))
        return http.build()
    }

}