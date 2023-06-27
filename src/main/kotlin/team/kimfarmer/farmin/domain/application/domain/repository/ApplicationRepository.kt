package team.kimfarmer.farmin.domain.application.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.application.domain.entity.Application

interface ApplicationRepository : CrudRepository<Application, Long> {
}