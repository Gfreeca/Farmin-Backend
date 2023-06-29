package team.kimfarmer.farmin.domain.announcement.presentation.data.dto

data class DetailAnnouncementDto (
        val idx: Long,
        val name: String,
        val farmName: String,
        val userName: String,
        val profile: String,
        val description: String,
        val pay: String,
        val mainBusiness: List<String>,
        val images: List<String>,
        val workingHours: List<WorkingHoursDto>,
        val period: List<String>,
        val benefit: List<String>,
        val deadline: String,
        val location: String,
        val isApplied: Boolean
) {
    data class WorkingHoursDto(
            val hour: String,
            val minute: String
    )
}