package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.Benefit

interface BenefitRepository : CrudRepository<Benefit, Long> {
    fun findBenefitsByAnnouncementIdx(announcementIdx: Announcement): List<Benefit>
}