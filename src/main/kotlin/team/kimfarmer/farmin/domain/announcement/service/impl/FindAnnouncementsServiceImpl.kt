package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.domain.repository.ImageRepository
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.farm.utils.FarmUtils

@Service
@Transactional(readOnly = true)
class FindAnnouncementsServiceImpl(
        private val announcementRepository: AnnouncementRepository,
        private val farmUtils: FarmUtils,
        private val imageRepository: ImageRepository,
        private val announcementConverter: AnnouncementConverter
) : FindAnnouncementsService {
    override fun execute(): List<AnnouncementDto> =
         announcementRepository.findAll()
                .map { it to farmUtils.findByFarmIdx(it.farmIdx) }
                .map {
                    val image = imageRepository.findImagesByAnnouncementIdx(it.first)[0].img
                    announcementConverter.toDto(it.first, image, it.second)
                }
}