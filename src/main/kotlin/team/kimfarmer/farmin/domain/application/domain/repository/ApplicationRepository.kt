package team.kimfarmer.farmin.domain.application.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.application.domain.entity.Application
import team.kimfarmer.farmin.domain.user.domain.entity.User

interface ApplicationRepository : CrudRepository<Application, Long> {
    fun existsByUserIdx(user: User): Boolean
}