package io.github.t3m8ch.springtodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringTodoApplication

fun main(args: Array<String>) {
    runApplication<SpringTodoApplication>(*args)
}
