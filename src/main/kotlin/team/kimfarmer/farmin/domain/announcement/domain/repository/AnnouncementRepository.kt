package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement

interface AnnouncementRepository : CrudRepository<Announcement, Long> {
    fun save(announcement: Announcement): Announcement
}