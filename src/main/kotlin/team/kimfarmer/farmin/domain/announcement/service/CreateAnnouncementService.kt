package team.kimfarmer.farmin.domain.announcement.service

import team.kimfarmer.farmin.domain.announcement.presentation.data.request.CreateAnnouncementRequestDto

interface CreateAnnouncementService {
    fun execute(request: CreateAnnouncementRequestDto)
}