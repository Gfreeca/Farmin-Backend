package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.Image

interface ImageRepository : CrudRepository<Image, Long> {
    fun findImagesByAnnouncementIdx(announcementIdx: Announcement): List<Image>
}