package team.kimfarmer.farmin.global.common.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseIdEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Long = 0
)
