package team.kimfarmer.farmin.domain.application.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.application.service.ApplyUserService

@RestController
@RequestMapping("/application")
class ApplicationController(
        private val applyUserService: ApplyUserService
) {
    @PostMapping("/{announcement_id}")
    fun applyUserInFarm(@PathVariable("announcement_id") announcementId: Long): ResponseEntity<Void> =
        applyUserService.execute(announcementId)
                .run { ResponseEntity.status(HttpStatus.CREATED).build() }
}