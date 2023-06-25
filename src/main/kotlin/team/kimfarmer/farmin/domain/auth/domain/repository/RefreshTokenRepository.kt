package team.kimfarmer.farmin.domain.auth.domain.repository

import team.kimfarmer.farmin.domain.auth.domain.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RefreshTokenRepository : CrudRepository<RefreshToken, UUID> {
}