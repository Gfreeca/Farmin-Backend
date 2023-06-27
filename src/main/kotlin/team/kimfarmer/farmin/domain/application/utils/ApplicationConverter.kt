package team.kimfarmer.farmin.domain.application.utils

import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.application.domain.entity.Application
import team.kimfarmer.farmin.domain.user.domain.entity.User


interface ApplicationConverter {
    fun toEntity(user: User, announcement: Announcement): Application
}