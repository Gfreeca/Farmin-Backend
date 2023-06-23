package team.kimfarmer.farmin.domain.auth.util

import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignUpRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto
import java.time.ZonedDateTime

interface AuthConverter {
    fun toDto(request: SignUpRequestDto): SignUpDto
    fun toDto(accessToken: String, refreshToken: String, accessExp: ZonedDateTime, refreshExp: ZonedDateTime): SignUpTokenDto
    fun toResponse(dto: SignUpTokenDto): SignUpResponseDto

}