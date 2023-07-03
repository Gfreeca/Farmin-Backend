package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.*
import team.kimfarmer.farmin.domain.announcement.exception.AnnouncementNotFoundException
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementByIdService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.application.domain.repository.ApplicationRepository
import team.kimfarmer.farmin.domain.farm.utils.FarmUtils
import team.kimfarmer.farmin.domain.user.utils.UserUtils

@Service
@Transactional(readOnly = true)
class FindAnnouncementByIdServiceImpl(
        private val announcementRepository: AnnouncementRepository,
        private val announcementConverter: AnnouncementConverter,
        private val benefitRepository: BenefitRepository,
        private val imageRepository: ImageRepository,
        private val mainBusinessRepository: MainBusinessRepository,
        private val periodRepository: PeriodRepository,
        private val workingHoursRepository: WorkingHoursRepository,
        private val farmUtils: FarmUtils,
        private val applicationRepository: ApplicationRepository,
        private val userUtils: UserUtils
) : FindAnnouncementByIdService {
    override fun execute(announcementId: Long): DetailAnnouncementDto {
        val user = userUtils.getCurrentUser()
        val announcement = announcementRepository.findByIdOrNull(announcementId)
                ?: throw AnnouncementNotFoundException()
        val farm = farmUtils.findByFarmIdx(announcement.farmIdx)
        val benefits = benefitRepository.findBenefitsByAnnouncementIdx(announcement)
                .map { it.content }
        val images = imageRepository.findImagesByAnnouncementIdx(announcement)
                .map { it.img }
        val mainBusinesses = mainBusinessRepository.findMainBusinessesByAnnouncementIdx(announcement)
                .map { it.content }
        val periods = periodRepository.findPeriodsByAnnouncementIdx(announcement)
                .map { it.date }
        val workingHours = workingHoursRepository.findWorkingHoursByAnnouncementIdx(announcement)
                .map { announcementConverter.toDto(it) }
        val isApplied = applicationRepository.existsByUserIdx(user)

        return announcementConverter.toDto(announcement, periods, farm, isApplied, mainBusinesses, benefits, images, workingHours)
    }
}