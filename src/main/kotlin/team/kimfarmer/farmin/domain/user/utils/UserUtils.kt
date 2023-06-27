package team.kimfarmer.farmin.domain.user.utils

import team.kimfarmer.farmin.domain.user.domain.entity.User

interface UserUtils {
    fun findUserById(id: String): User
    fun getCurrentUser(): User
}