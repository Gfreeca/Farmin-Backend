package team.kimfarmer.farmin.domain.auth.service

import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignInDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignInTokenDto

interface SignInService {
    fun execute(dto: SignInDto): SignInTokenDto
}