package team.kimfarmer.farmin.domain.user.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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
        val location: String,

        @Column(nullable = false)
        val description: String,

        @Column(nullable = false)
        val profileImg: String
) : BaseIdEntity()