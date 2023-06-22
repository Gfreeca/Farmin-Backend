package team.kimfarmer.farmin.global.redis.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.redis")
data class RedisProperties(
    val host: String,
    val port: Int
)