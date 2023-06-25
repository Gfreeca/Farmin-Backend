package team.kimfarmer.farmin.domain.auth.presentation.data.dto

import java.time.ZonedDateTime

data class SignInTokenDto(
        val accessToken: String,
        val refreshToken: String,
        val accessExp: ZonedDateTime,
        val refreshExp: ZonedDateTime
)