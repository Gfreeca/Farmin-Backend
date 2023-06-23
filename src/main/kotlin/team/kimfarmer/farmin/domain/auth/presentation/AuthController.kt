package team.kimfarmer.farmin.domain.auth.presentation

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
@RequestMapping("/auth")
class AuthController(
        private val signUpService: SignUpService,
        private val authConverter: AuthConverter
) {
    @PostMapping("sign-up")
    fun signUp(@RequestBody request: SignUpRequestDto): ResponseEntity<SignUpResponseDto> =
            authConverter.toDto(request)
                    .let { signUpService.execute(it) }
                    .let { authConverter.toResponse(it) }
                    .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
}