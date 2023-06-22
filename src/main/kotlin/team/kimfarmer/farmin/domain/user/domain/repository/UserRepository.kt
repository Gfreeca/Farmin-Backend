package team.kimfarmer.farmin.domain.user.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.user.domain.entity.User

interface UserRepository : CrudRepository<User, Long> {
    fun findById(id: String): User?
}