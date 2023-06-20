package team.kimfarmer.farmin.domain.announcement.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import team.kimfarmer.farmin.global.common.entity.BaseIdEntity

@Entity
data class Announcement(
        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val location: String,

        @Column(nullable = false)
        val description: String,

        @Column(nullable = false)
        val pay: String,

        @Column(nullable = false)
        val deadline: String,

        @Column(nullable = false)
        val kind: String,

        @Column(nullable = false)
        val userIdx: Long
) : BaseIdEntity()
