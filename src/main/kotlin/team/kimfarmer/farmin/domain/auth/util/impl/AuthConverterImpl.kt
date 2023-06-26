package team.kimfarmer.farmin.domain.auth.util.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.auth.domain.entity.RefreshToken
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignInDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignInTokenDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignInRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignUpRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignInResponseDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto
import team.kimfarmer.farmin.domain.auth.util.AuthConverter
import team.kimfarmer.farmin.domain.user.domain.entity.User

@Component
class AuthConverterImpl : AuthConverter {
    override fun toDto(request: SignUpRequestDto): SignUpDto =
            SignUpDto(
                    name = request.name,
                    phoneNumber = request.phoneNumber,
                    id = request.id,
                    password = request.password,
                    location = request.location,
                    profileImg = request.profileImg,
                    description = request.description
            )

    override fun toDto(request: SignInRequestDto): SignInDto =
            SignInDto(
                    id = request.id,
                    password = request.password
            )

    override fun toResponse(dto: SignUpTokenDto): SignUpResponseDto =
            SignUpResponseDto(
                    accessToken = dto.accessToken,
                    refreshToken = dto.refreshToken,
                    accessExp = dto.accessExp,
                    refreshExp = dto.refreshExp
            )

    override fun toResponse(dto: SignInTokenDto): SignInResponseDto =
            SignInResponseDto(
                    accessToken = dto.refreshToken,
                    refreshToken = dto.refreshToken,
                    accessExp = dto.accessExp,
                    refreshExp = dto.refreshExp
            )
    override fun toEntity(token: String, id: String, timeToLive: Long): RefreshToken =
            RefreshToken(
                    userId = id,
                    token = token,
                    timeToLive = timeToLive
            )

    override fun toEntity(dto: SignUpDto, encodedPassword: String): User =
            User(
                    id = dto.id,
                    password = encodedPassword,
                    name = dto.name,
                    phoneNumber = dto.phoneNumber,
                    location = dto.location,
                    description = dto.description
            )
}