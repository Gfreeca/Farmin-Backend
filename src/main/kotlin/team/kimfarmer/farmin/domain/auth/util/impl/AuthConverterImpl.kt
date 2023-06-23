package team.kimfarmer.farmin.domain.auth.util.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto
import team.kimfarmer.farmin.domain.auth.presentation.data.request.SignUpRequestDto
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto
import team.kimfarmer.farmin.domain.auth.util.AuthConverter
import java.time.ZonedDateTime

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

    override fun toDto(accessToken: String, refreshToken: String, accessExp: ZonedDateTime, refreshExp: ZonedDateTime): SignUpTokenDto =
            SignUpTokenDto(
                    accessToken = accessToken,
                    refreshToken = refreshToken,
                    accessExp = accessExp,
                    refreshExp = refreshExp
            )

    override fun toResponse(dto: SignUpTokenDto): SignUpResponseDto =
            SignUpResponseDto(
                    accessToken = dto.accessToken,
                    refreshToken = dto.refreshToken,
                    accessExp = dto.accessExp,
                    refreshExp = dto.refreshExp
            )
}