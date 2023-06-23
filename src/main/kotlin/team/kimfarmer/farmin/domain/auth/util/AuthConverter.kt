package team.kimfarmer.farmin.domain.auth.util

import team.kimfarmer.farmin.domain.auth.domain.entity.RefreshToken
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignUpRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto
import team.kimfarmer.farmin.domain.user.domain.entity.User

interface AuthConverter {
    fun toDto(request: SignUpRequestDto): SignUpDto
    fun toResponse(dto: SignUpTokenDto): SignUpResponseDto
    fun toEntity(token: String, id: String, timeToLive: Long): RefreshToken
    fun toEntity(dto: SignUpDto, encodedPassword: String): User
}