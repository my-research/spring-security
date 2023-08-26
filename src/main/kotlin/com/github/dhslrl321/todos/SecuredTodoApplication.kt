package com.github.dhslrl321.todos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.github.dhslrl321"])
class SecuredTodoApplication

fun main(args: Array<String>) {
  runApplication<SecuredTodoApplication>(*args)
}
