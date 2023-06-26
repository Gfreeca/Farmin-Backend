package team.kimfarmer.farmin.domain.application.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/application")
class ApplicationController(
) {
    @PostMapping("/{announcement_id}")
    fun applyUserInFarm(@PathVariable("announcement_id") announcementId: Int): ResponseEntity<Void> {
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}