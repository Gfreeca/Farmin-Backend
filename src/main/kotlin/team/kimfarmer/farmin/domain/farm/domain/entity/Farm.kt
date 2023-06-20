package team.kimfarmer.farmin.domain.farm.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.kimfarmer.farmin.domain.user.domain.entity.User
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
class Farm(
        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val phoneNumber: String,

        @Column(nullable = false)
        val businessNumber: String,

        @Column(nullable = false)
        val location: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(nullable = false, name = "user_idx")
        val userIdx: User
) : BaseIdEntity()