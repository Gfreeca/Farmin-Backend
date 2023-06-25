package team.kimfarmer.farmin.domain.auth.service

import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpDto
import team.kimfarmer.farmin.domain.auth.presentation.data.dto.SignUpTokenDto

interface SignUpService {
    fun execute(dto: SignUpDto): SignUpTokenDto
}