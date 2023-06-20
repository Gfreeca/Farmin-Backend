package team.kimfarmer.farmin.domain.announcement.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
class WorkingHours(
        @Column(nullable = false)
        val hour: String,

        @Column(nullable = false)
        val minute: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(nullable = false)
        val announcementIdx: Announcement
) : BaseIdEntity()