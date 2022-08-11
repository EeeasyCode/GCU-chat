package com.gcu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GcuApplication

fun main(args: Array<String>) {
    runApplication<GcuApplication>(*args)
}
