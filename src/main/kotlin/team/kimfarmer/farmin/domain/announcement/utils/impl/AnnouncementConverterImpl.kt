package team.kimfarmer.farmin.domain.announcement.utils.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter

@Component
class AnnouncementConverterImpl : AnnouncementConverter {
    override fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto =
            AnnouncementResponseDto(
                    thumbnail = dto.thumbnail,
                    name = dto.name,
                    location = dto.location,
                    pay = dto.pay,
                    farmName = dto.farmName
            )
}