package team.kimfarmer.farmin.domain.announcement.utils

import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.WorkingHours
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.DetailAnnouncementResponseDto
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm

interface AnnouncementConverter {
    fun toDto(announcement: Announcement, farm: Farm): AnnouncementDto
    fun toDto(workingHours: WorkingHours): DetailAnnouncementDto.WorkingHoursDto
    fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto
    fun toResponse(dto: DetailAnnouncementDto, workingHours: List<DetailAnnouncementResponseDto.WorkingHoursResponseDto>): DetailAnnouncementResponseDto
}