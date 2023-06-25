package team.kimfarmer.farmin.domain.auth.presentation.data.dto

data class SignUpDto(
        val name: String,
        val phoneNumber: String,
        val id: String,
        val password: String,
        val location: String,
        val profileImg: String,
        val description: String
)