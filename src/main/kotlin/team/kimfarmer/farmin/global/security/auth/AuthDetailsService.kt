package team.kimfarmer.farmin.global.security.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.user.domain.repository.UserRepository
import team.kimfarmer.farmin.domain.user.exception.UserNotFoundException

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findById(username) ?: throw UserNotFoundException()
        return AuthDetails(user)
    }
}