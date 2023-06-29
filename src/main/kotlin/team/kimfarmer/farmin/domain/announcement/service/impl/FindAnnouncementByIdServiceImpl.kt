package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementByIdService

@Service
@Transactional(readOnly = true)
class FindAnnouncementByIdServiceImpl(
        private val announcementRepository: AnnouncementRepository
) : FindAnnouncementByIdService {
    override fun execute(announcementId: Long): DetailAnnouncementDto {
        TODO("Not yet implemented")
    }
}