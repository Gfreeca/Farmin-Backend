package team.kimfarmer.farmin.global.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
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
        val jwtSchemeName = "jwtAuth"
        val securityRequirement = SecurityRequirement().addList(jwtSchemeName)
        val components = Components()
                .addSecuritySchemes(jwtSchemeName, SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("bearer")
                        .bearerFormat("JWT"))

        return Info()
                .title("FARMIN API")
                .description("farmin api 입니다")
                .version("1.0.0")
                .let { info ->
                    OpenAPI()
                            .addSecurityItem(securityRequirement)
                            .components(components)
                            .info(info)
                }
    }
}