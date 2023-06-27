package team.kimfarmer.farmin.domain.application.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.repository.AnnouncementRepository
import team.kimfarmer.farmin.domain.announcement.exception.AnnouncementNotFoundException
import team.kimfarmer.farmin.domain.application.domain.repository.ApplicationRepository
import team.kimfarmer.farmin.domain.application.service.ApplyUserService
import team.kimfarmer.farmin.domain.application.utils.ApplicationConverter
import team.kimfarmer.farmin.domain.user.utils.UserUtils

@Service
@Transactional
class ApplyUserServiceImpl(
        private val userUtils: UserUtils,
        private val announcementRepository: AnnouncementRepository,
        private val applicationRepository: ApplicationRepository,
        private val applicationConverter: ApplicationConverter
) : ApplyUserService {
    override fun execute(announcementId: Long) {
        val user = userUtils.getCurrentUser()
        val announcement = announcementRepository.findByIdOrNull(announcementId) ?: throw AnnouncementNotFoundException()

        applicationRepository.save(applicationConverter.toEntity(user, announcement))
    }
}