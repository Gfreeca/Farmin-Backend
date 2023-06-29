package team.kimfarmer.farmin.domain.announcement.presentation.data.response

data class DetailAnnouncementResponseDto (
        val idx: Long,
        val name: String,
        val farmName: String,
        val userName: String,
        val userProfile: String,
        val description: String,
        val pay: String,
        val mainBusiness: List<String>,
        val images: List<String>,
        val workingHours: List<WorkingHoursResponseDto>,
        val period: List<String>,
        val benefit: List<String>,
        val deadline: String,
        val location: String,
        val isApplied: Boolean
) {
    data class WorkingHoursResponseDto(
            val hour: String,
            val minute: String
    )
}