package team.kimfarmer.farmin.domain.announcement.presentation.data.dto

data class AnnouncementDto(
    val idx: Long,
    val thumbnail: String,
    val name: String,
    val location: String,
    val pay: String,
    val farmName: String
)