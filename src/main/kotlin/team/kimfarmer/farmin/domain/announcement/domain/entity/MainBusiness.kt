package team.kimfarmer.farmin.domain.announcement.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
class MainBusiness(
        @Column(nullable = false)
        val content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(nullable = false)
        val announcementIdx: Announcement
) : BaseIdEntity()