package team.kimfarmer.farmin.domain.user.utils.impl

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.user.domain.entity.User
import team.kimfarmer.farmin.domain.user.domain.repository.UserRepository
import team.kimfarmer.farmin.domain.user.exception.UserNotFoundException
import team.kimfarmer.farmin.domain.user.utils.UserUtils

@Component
class UserUtilsImpl(
    private val userRepository: UserRepository
) : UserUtils {
    override fun findUserById(id: String): User = userRepository.findById(id)?:throw UserNotFoundException()
    override fun getCurrentUser(): User {
        val userId: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }
}