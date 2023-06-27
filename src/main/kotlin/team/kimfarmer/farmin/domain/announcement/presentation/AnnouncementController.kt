package team.kimfarmer.farmin.domain.announcement.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter

@RestController
@RequestMapping("/announcement")
class AnnouncementController(
        private val findAnnouncementsService: FindAnnouncementsService,
        private val announcementConverter: AnnouncementConverter
) {
    @GetMapping
    fun findAnnouncements(): ResponseEntity<List<AnnouncementResponseDto>> =
            findAnnouncementsService.execute()
                    .map { announcementConverter.toResponse(it) }
                    .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}