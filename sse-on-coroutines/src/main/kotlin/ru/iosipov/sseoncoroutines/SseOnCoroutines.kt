package ru.iosipov.sseoncoroutines

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SseOnCoroutinesApplication

fun main(args: Array<String>) {
	runApplication<SseOnCoroutinesApplication>(*args)
}
