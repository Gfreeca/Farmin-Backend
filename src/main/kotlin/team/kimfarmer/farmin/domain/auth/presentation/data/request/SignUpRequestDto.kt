package team.kimfarmer.farmin.domain.auth.presentation.data.request

data class SignUpRequestDto(
        val name: String,
        val phoneNumber: String,
        val id: String,
        val password: String,
        val location: String,
        val profileImg: String,
        val description: String
)
