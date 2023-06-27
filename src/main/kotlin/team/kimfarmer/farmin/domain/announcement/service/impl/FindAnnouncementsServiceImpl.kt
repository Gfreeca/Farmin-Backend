package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService

@Service
@Transactional(readOnly = true)
class FindAnnouncementsServiceImpl(
        private val announcementRepository: AnnouncementRepository
) : FindAnnouncementsService {
    override fun execute(): List<AnnouncementDto> {
        return TODO("Provide the return value")
    }
}