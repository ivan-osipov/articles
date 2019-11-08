package ru.iosipov.sseoncoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@CrossOrigin
@RestController
@RequestMapping("/events")
class EventsController {

    val channels: MutableSet<Channel<String>> = ConcurrentHashMap.newKeySet()

    @GetMapping("/stream")
    fun eventStream(): Flow<String> {
        val channel = Channel<String>()
        channel.invokeOnClose {
            channels.remove(channel)
            println("Closing. Size: ${channels.size}")
        }
        channels.add(channel)
        println("Opening. Size: ${channels.size}")
        return channel.consumeAsFlow()
    }

    @Scheduled(fixedDelay = 1000)
    fun onEvent() {
        GlobalScope.launch {
            channels.forEach {
                it.send(Date().toString())
            }
        }
    }
}