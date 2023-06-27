package team.kimfarmer.farmin.domain.application.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.kimfarmer.farmin.domain.application.service.ApplyUserService
import team.kimfarmer.farmin.domain.auth.presentation.data.response.SignUpResponseDto

@RestController
@Tag(name = "application", description = "지원 API")
@RequestMapping("/application")
class ApplicationController(
        private val applyUserService: ApplyUserService
) {
    @PostMapping("/{announcement_id}")
    @Operation(summary = "지원하기", description = "인력공고에 지원 신청하기")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "201", description = "지원하기 성공",
                        content = [Content(schema = Schema(implementation = SignUpResponseDto::class))]
                ),
                ApiResponse(
                        responseCode = "400", description = "요청값이 올바르지 않을 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "401", description = "권한이 없는 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "404", description = "존재하지 않는 유저",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "404", description = "존재하지 않는 농장",
                        content = [Content(schema = Schema(implementation = String::class))]
                )

            ]
    )
    fun applyUserInFarm(@PathVariable("announcement_id") announcementId: Long): ResponseEntity<Void> =
        applyUserService.execute(announcementId)
                .run { ResponseEntity.status(HttpStatus.CREATED).build() }
}