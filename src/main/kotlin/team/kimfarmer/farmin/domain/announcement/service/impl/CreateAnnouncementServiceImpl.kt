package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.presentation.data.request.CreateAnnouncementRequestDto
import team.kimfarmer.farmin.domain.announcement.service.CreateAnnouncementService

@Service
@Transactional
class CreateAnnouncementServiceImpl(
        val announcementRepository: AnnouncementRepository,
) : CreateAnnouncementService {
    override fun execute(request: CreateAnnouncementRequestDto) {

    }
}