package team.kimfarmer.farmin.domain.user.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
class User(
        @Column(nullable = false)
        val id: String,

        @Column(nullable = false)
        val password: String,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val phoneNumber: String,

        @Column(nullable = false)
        val businessNumber: String,

        @Column(nullable = false)
        val location: String,

        @Column(nullable = false)
        val description: String
) : BaseIdEntity()