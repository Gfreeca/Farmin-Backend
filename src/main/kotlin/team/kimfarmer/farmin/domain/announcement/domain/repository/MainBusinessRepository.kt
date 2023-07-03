package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.MainBusiness

interface MainBusinessRepository : CrudRepository<MainBusiness, Long> {
    fun findMainBusinessesByAnnouncementIdx(announcementIdx: Announcement): List<MainBusiness>
}