package team.kimfarmer.farmin.domain.announcement.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.DetailAnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto

@RestController
@Tag(name = "announcement", description = "공고 API")
@RequestMapping("/announcement")
class AnnouncementController(
        private val findAnnouncementsService: FindAnnouncementsService,
        private val announcementConverter: AnnouncementConverter
) {
    @GetMapping
    @Operation(summary = "지원하기", description = "인력공고에 지원 신청하기")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "200", description = "농촌 공고리스트 불러오기 성공",
                        content = [Content(schema = Schema(implementation = SignUpResponseDto::class))]
                ),
                ApiResponse(
                        responseCode = "401", description = "권한이 없는 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "404", description = "존재하지 않는 농장",
                        content = [Content(schema = Schema(implementation = String::class))]
                )

            ]
    )
    fun findAnnouncements(): ResponseEntity<List<AnnouncementResponseDto>> =
            findAnnouncementsService.execute()
                    .map { announcementConverter.toResponse(it) }
                    .let { ResponseEntity.status(HttpStatus.OK).body(it) }
    @GetMapping("/{announcement_id}")
    fun findAnnouncementById(@PathVariable("announcement_id") announcementId: String): ResponseEntity<DetailAnnouncementResponseDto> {
        return TODO("서비스 구현하고 로직 수정하기")
    }
}