package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.exception.AnnouncementNotFoundException
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementByIdService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter

@Service
@Transactional(readOnly = true)
class FindAnnouncementByIdServiceImpl(
        private val announcementRepository: AnnouncementRepository,
        private val announcementConverter: AnnouncementConverter
) : FindAnnouncementByIdService {
    override fun execute(announcementId: Long): DetailAnnouncementDto {
        val announcement = announcementRepository.findByIdOrNull(announcementId) ?: throw AnnouncementNotFoundException()
        val periodList = announcement.period.map { it.date }.sorted()
        val mainBusinessList = announcement.mainBusiness.map { it.content }
        val benefitList = announcement.benefit.map { it.content }
        val image = announcement.image.map { it.img }
        val workingHours = announcement.workingHours.map { announcementConverter.toDto(it) }

    }
}