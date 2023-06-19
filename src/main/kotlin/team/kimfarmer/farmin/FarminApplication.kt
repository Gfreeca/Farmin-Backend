package team.kimfarmer.farmin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FarminApplication

fun main(args: Array<String>) {
    runApplication<FarminApplication>(*args)
}
