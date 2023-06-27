package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.farm.domain.repository.FarmRepository

@Service
@Transactional(readOnly = true)
class FindAnnouncementsServiceImpl(
        private val announcementRepository: AnnouncementRepository,
        private val farmRepository: FarmRepository,
        private val announcementConverter: AnnouncementConverter
) : FindAnnouncementsService {
    override fun execute(): List<AnnouncementDto> =
         announcementRepository.findAll()
                .map { it to farmRepository.findByIdOrNull(it.farmIdx) }
                .map { announcementConverter.toDto(it.first, it.second!!) }
}