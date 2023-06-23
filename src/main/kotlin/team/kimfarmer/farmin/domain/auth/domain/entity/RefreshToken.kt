package team.kimfarmer.farmin.domain.auth.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.UUID

@RedisHash(value = "refreshToken")
class RefreshToken(
    @Indexed
    val userId: String,

    @Id
    @Indexed
    val token: String,

    @TimeToLive
    val timeToLive: Long
)