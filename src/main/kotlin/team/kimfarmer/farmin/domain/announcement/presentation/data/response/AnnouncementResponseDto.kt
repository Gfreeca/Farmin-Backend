package team.kimfarmer.farmin.domain.announcement.presentation.data.response

data class AnnouncementResponseDto(
    val idx: Long,
    val thumbnail: String,
    val name: String,
    val location: String,
    val pay: String,
    val farmName: String
)
