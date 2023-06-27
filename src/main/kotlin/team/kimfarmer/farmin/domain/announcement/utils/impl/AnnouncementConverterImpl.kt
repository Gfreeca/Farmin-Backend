package team.kimfarmer.farmin.domain.announcement.utils.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm

@Component
class AnnouncementConverterImpl : AnnouncementConverter {
    override fun toDto(announcement: Announcement, farm: Farm): AnnouncementDto =
            AnnouncementDto(
                    thumbnail = announcement.thumbnail,
                    name = announcement.name,
                    pay = announcement.pay,
                    location = farm.location,
                    farmName = farm.name
            )

    override fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto =
            AnnouncementResponseDto(
                    thumbnail = dto.thumbnail,
                    name = dto.name,
                    location = dto.location,
                    pay = dto.pay,
                    farmName = dto.farmName
            )
}