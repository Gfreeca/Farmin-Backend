package team.kimfarmer.farmin.domain.announcement.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.announcement.domain.entity.*
import team.kimfarmer.farmin.domain.announcement.domain.repository.*
import team.kimfarmer.farmin.domain.announcement.presentation.data.request.CreateAnnouncementRequestDto
import team.kimfarmer.farmin.domain.announcement.service.CreateAnnouncementService
import team.kimfarmer.farmin.domain.user.utils.UserUtils

@Service
@Transactional
class CreateAnnouncementServiceImpl(
        val announcementRepository: AnnouncementRepository,
        val benefitRepository: BenefitRepository,
        val imageRepository: ImageRepository,
        val mainBusinessRepository: MainBusinessRepository,
        val periodRepository: PeriodRepository,
        val workingHoursRepository: WorkingHoursRepository,
        val userUtils: UserUtils
) : CreateAnnouncementService {
    override fun execute(request: CreateAnnouncementRequestDto) {
        val user = userUtils.getCurrentUser()
        val announcement = Announcement(
                name = request.name,
                description = request.description,
                pay = request.pay,
                thumbnail = request.thumbnail,
                deadline = request.deadline,
                farmIdx = request.farmIdx,
                userIdx = user
        )
        val savedAnnouncement = announcementRepository.save(announcement)

        val benefits = request.benefit
                .map { Benefit(
                        content = it,
                        announcementIdx = savedAnnouncement
                ) }
        val images =  request.image
                .map { Image(
                        img = it,
                        announcementIdx = savedAnnouncement
                ) }
        val mainBusinesses = request.mainBusiness
                .map {
                    MainBusiness(
                            content = it,
                            announcementIdx = savedAnnouncement
                    )
                }
        val periods = request.period
                .map {
                    Period(
                          date = it,
                          announcementIdx = savedAnnouncement
                    )
                }
        val workingHours = request.workingHours
                .map {
                    WorkingHours(
                            hour = it.hour,
                            minute = it.minute,
                            announcementIdx = savedAnnouncement
                    )
                }


        benefitRepository.saveAll(benefits)
        imageRepository.saveAll(images)
        mainBusinessRepository.saveAll(mainBusinesses)
        periodRepository.saveAll(periods)
        workingHoursRepository.saveAll(workingHours)
    }
}
