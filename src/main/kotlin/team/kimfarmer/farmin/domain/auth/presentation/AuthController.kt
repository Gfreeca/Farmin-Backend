package team.kimfarmer.farmin.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignUpRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto
import team.kimfarmer.farmin.domain.auth.service.SignUpService
import team.kimfarmer.farmin.domain.auth.util.AuthConverter

@RestController
@Tag(name = "auth", description = "인증 API")
@RequestMapping("/auth")
class AuthController(
        private val signUpService: SignUpService,
        private val authConverter: AuthConverter
) {
    @PostMapping("sign-up")
    @Operation(summary = "회원 가입", description = "유저 회원가입을 시킴")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "201", description = "회원가입 성공",
                        content = [Content(schema = Schema(implementation = SignUpResponseDto::class))]
                ),
                ApiResponse(
                        responseCode = "400", description = "요청값이 올바르지 않을 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "409", description = "유저가 이미 존재하는 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                )
            ]
    )
    fun signUp(@RequestBody request: SignUpRequestDto): ResponseEntity<SignUpResponseDto> =
            authConverter.toDto(request)
                    .let { signUpService.execute(it) }
                    .let { authConverter.toResponse(it) }
                    .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
}