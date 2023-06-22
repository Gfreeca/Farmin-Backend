package team.kimfarmer.farmin.global.security.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt.time")
class TokenTimeProperties (
    val accessTime: Long,
    val refreshTime: Long
)