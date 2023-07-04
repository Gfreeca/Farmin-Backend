package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.Period

interface PeriodRepository : CrudRepository<Period, Long> {
    fun findPeriodsByAnnouncementIdx(announcementIdx: Announcement): List<Period>
}