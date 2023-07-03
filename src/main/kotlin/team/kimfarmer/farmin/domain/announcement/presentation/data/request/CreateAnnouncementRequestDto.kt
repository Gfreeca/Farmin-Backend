package team.kimfarmer.farmin.domain.announcement.presentation.data.request


data class CreateAnnouncementRequestDto (
        val name: String,
        val description: String,
        val pay: String,
        val deadline: String,
        val thumbnail: String,
        val farmIdx: String,
        val benefit: List<String>,
        val image: List<String>,
        val mainBusiness: List<String>,
        val period: List<String>,
        val workingHours: List<WorkingHoursRequestDto>
) {
    data class WorkingHoursRequestDto (
            val hour: String,
            val minute: String
    )
}