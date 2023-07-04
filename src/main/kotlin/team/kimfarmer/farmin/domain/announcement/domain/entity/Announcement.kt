package team.kimfarmer.farmin.domain.announcement.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.kimfarmer.farmin.domain.user.domain.entity.User
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
class Announcement(
        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val description: String,

        @Column(nullable = false)
        val pay: String,

        @Column(nullable = false)
        val deadline: String,

        @Column(nullable = false)
        val farmIdx: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(nullable = false, name = "user_idx")
        val userIdx: User
) : BaseIdEntity()
