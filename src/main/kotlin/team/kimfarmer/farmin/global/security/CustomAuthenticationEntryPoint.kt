package team.kimfarmer.farmin.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.ErrorResponse

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {

    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun commence(
            request: HttpServletRequest,
            response: HttpServletResponse,
            authException: AuthenticationException
    ) {
        log.error("==========Access Denied==========")
        val errorCode = ErrorCode.UNAUTHORIZED
        val responseString = objectMapper.writeValueAsString(ErrorResponse(errorCode.message, errorCode.status))
        response.characterEncoding = "UTF-8"
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(responseString)
    }
}