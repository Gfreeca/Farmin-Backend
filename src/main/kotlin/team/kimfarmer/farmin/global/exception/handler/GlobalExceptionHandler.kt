package team.kimfarmer.farmin.global.exception.handler

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.ErrorResponse
import team.kimfarmer.farmin.global.exception.exceptions.BasicException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BasicException::class)
    fun globalExceptionHandler(request: HttpServletRequest, e: BasicException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = e.errorCode
        return ResponseEntity(
            ErrorResponse(status = errorCode.status, message = errorCode.message),
            HttpStatus.valueOf(errorCode.status)
        )
    }
}