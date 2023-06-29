package team.kimfarmer.farmin.domain.announcement.service

import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto

interface FindAnnouncementByIdService {
    fun execute(announcementId: Long): DetailAnnouncementDto
}