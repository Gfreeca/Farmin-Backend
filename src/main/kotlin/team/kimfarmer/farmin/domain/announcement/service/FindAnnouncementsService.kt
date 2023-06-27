package team.kimfarmer.farmin.domain.announcement.service

import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto

interface FindAnnouncementsService {
    fun execute(): List<AnnouncementDto>
}