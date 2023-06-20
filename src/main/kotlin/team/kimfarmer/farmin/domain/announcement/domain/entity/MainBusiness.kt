package team.kimfarmer.farmin.domain.announcement.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
data class MainBusiness(
        @Column(nullable = false)
        val content: String,

        val announcementIdx: String
) : BaseIdEntity()
