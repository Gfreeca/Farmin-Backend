package team.kimfarmer.farmin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class FarminApplication

fun main(args: Array<String>) {
    runApplication<FarminApplication>(*args)
}
