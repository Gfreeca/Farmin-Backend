package team.kimfarmer.farmin.domain.auth.presentation.data.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class SignUpTokenDto(
        val accessToken: String,
        val refreshToken: String,
        val accessExp: ZonedDateTime,
        val refreshExp: ZonedDateTime
)