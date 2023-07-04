package team.kimfarmer.farmin.domain.announcement.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.announcement.presentation.data.request.CreateAnnouncementRequestDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.DetailAnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.service.CreateAnnouncementService
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementByIdService
import team.kimfarmer.farmin.domain.announcement.service.FindAnnouncementsService
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter

@RestController
@Tag(name = "announcement", description = "공고 API")
@RequestMapping("/announcement")
class AnnouncementController(
        private val findAnnouncementService: FindAnnouncementsService,
        private val findAnnouncementByIdService: FindAnnouncementByIdService,
        private val createAnnouncementService: CreateAnnouncementService,
        private val announcementConverter: AnnouncementConverter
) {
    @GetMapping
    @Operation(summary = "인력 공고리스트 불러오기", description = "인력공고에 리스트 불러오기")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "200", description = "농촌 공고리스트 불러오기 성공",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = AnnouncementResponseDto::class)))]
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
            findAnnouncementService.execute()
                    .map { announcementConverter.toResponse(it) }
                    .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/{announcement_id}")
    @Operation(summary = "공고 상세페이지 보기", description = "")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "200", description = "농촌 공고 상세페이지 불러오기 성공",
                        content = [Content(schema = Schema(implementation = DetailAnnouncementResponseDto::class))]
                ),
                ApiResponse(
                        responseCode = "401", description = "권한이 없는 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "404", description = "존재하지 않는 공고",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "404", description = "존재하지 않는 농장",
                        content = [Content(schema = Schema(implementation = String::class))]
                )

            ]
    )
    fun findAnnouncementById(@PathVariable("announcement_id") announcementId: Long): ResponseEntity<DetailAnnouncementResponseDto> {
        val detailAnnouncementDto = findAnnouncementByIdService.execute(announcementId = announcementId)
        val workingHoursResponse = detailAnnouncementDto.workingHours
                .map { announcementConverter.toResponse(it) }
        val response = announcementConverter.toResponse(detailAnnouncementDto, workingHoursResponse)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
    @PostMapping
    fun createAnnouncement(@RequestBody request: CreateAnnouncementRequestDto): ResponseEntity<Void> =
        createAnnouncementService.execute(request)
                .run { ResponseEntity.status(HttpStatus.CREATED).build() }

}