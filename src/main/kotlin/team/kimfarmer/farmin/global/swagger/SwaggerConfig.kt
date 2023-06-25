package team.kimfarmer.farmin.global.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun groupedApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
                .group("FARMIN API")
                .pathsToMatch("/**")
                .build()
    }

    @Bean
    fun v1Api(): OpenAPI {
        return Info().title("FARMIN API")
                .description("farmin api 입니다")
                .version("1.0.0")
                .let { info -> OpenAPI().info(info) }
    }
}