package team.kimfarmer.farmin.domain.application.utils.impl

import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.announcement.domain.entity.Announcement
import team.kimfarmer.farmin.domain.application.domain.entity.Application
import team.kimfarmer.farmin.domain.application.utils.ApplicationConverter
import team.kimfarmer.farmin.domain.user.domain.entity.User

@Component
class ApplicationConverterImpl : ApplicationConverter {
    override fun toEntity(user: User, announcement: Announcement): Application =
            Application(
                    userIdx = user,
                    announcementIdx = announcement
            )
}