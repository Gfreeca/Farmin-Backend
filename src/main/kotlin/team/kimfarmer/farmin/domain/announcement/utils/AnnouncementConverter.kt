package team.kimfarmer.farmin.domain.announcement.utils

import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto

interface AnnouncementConverter {
    fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto
}