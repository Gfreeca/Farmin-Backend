package team.kimfarmer.farmin.domain.announcement.utils.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.announcement.domain.entity.WorkingHours
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.AnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.dto.DetailAnnouncementDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.AnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.presentation.data.response.DetailAnnouncementResponseDto
import team.kimfarmer.farmin.domain.announcement.utils.AnnouncementConverter
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm

@Component
class AnnouncementConverterImpl : AnnouncementConverter {
    override fun toDto(announcement: Announcement, image: String ,farm: Farm): AnnouncementDto =
            AnnouncementDto(
                    idx = announcement.idx,
                    thumbnail = image,
                    name = announcement.name,
                    pay = announcement.pay,
                    location = farm.location,
                    farmName = farm.name
            )

    override fun toDto(workingHours: WorkingHours): DetailAnnouncementDto.WorkingHoursDto =
            DetailAnnouncementDto.WorkingHoursDto(
                    hour = workingHours.hour,
                    minute = workingHours.minute
            )

    override fun toDto(announcement: Announcement, periodList: List<String>, farm: Farm, applied: Boolean, mainBusinessList: List<String>, benefitList: List<String>, image: List<String>, workingHours: List<DetailAnnouncementDto.WorkingHoursDto>): DetailAnnouncementDto =
            DetailAnnouncementDto(
                    idx = announcement.idx,
                    name = announcement.name,
                    farmName = farm.name,
                    location = farm.location,
                    userName = announcement.userIdx.name,
                    userProfile = announcement.userIdx.profileImg,
                    description = announcement.description,
                    pay = announcement.pay,
                    deadline = announcement.deadline,
                    isApplied = applied,
                    mainBusiness = mainBusinessList,
                    images = image,
                    workingHours = workingHours,
                    period = periodList,
                    benefit = benefitList
            )

    override fun toResponse(dto: AnnouncementDto): AnnouncementResponseDto =
            AnnouncementResponseDto(
                    idx = dto.idx,
                    thumbnail = dto.thumbnail,
                    name = dto.name,
                    location = dto.location,
                    pay = dto.pay,
                    farmName = dto.farmName
            )

    override fun toResponse(dto: DetailAnnouncementDto, workingHours: List<DetailAnnouncementResponseDto.WorkingHoursResponseDto>): DetailAnnouncementResponseDto =
            DetailAnnouncementResponseDto(
                    idx = dto.idx,
                    name = dto.name,
                    farmName = dto.farmName,
                    userName = dto.userName,
                    userProfile = dto.userProfile,
                    description = dto.description,
                    pay = dto.pay,
                    mainBusiness = dto.mainBusiness,
                    images = dto.images,
                    period = dto.period,
                    benefit = dto.benefit,
                    deadline = dto.deadline,
                    location = dto.location,
                    isApplied = dto.isApplied,
                    workingHours = workingHours

            )

    override fun toResponse(dto: DetailAnnouncementDto.WorkingHoursDto): DetailAnnouncementResponseDto.WorkingHoursResponseDto =
            DetailAnnouncementResponseDto.WorkingHoursResponseDto(
                    hour = dto.hour,
                    minute = dto.minute
            )
}