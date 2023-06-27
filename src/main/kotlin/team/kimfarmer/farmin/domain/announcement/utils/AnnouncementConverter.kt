package team.kimfarmer.farmin.domain.announcement.utils

import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm

interface AnnouncementConverter {
    fun toDto(announcement: Announcement, farm: Farm): AnnouncementDto
    fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto
}