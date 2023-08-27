package com.github.dhslrl321.todos.feature.todo

import com.github.dhslrl321.todos.spring.security.UnauthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalEndpointExceptionHandler {

  @ExceptionHandler(IllegalArgumentException::class)
  fun handle(ex: IllegalArgumentException): ResponseEntity<Map<String, String>> {
    if (ex.localizedMessage.startsWith("[todos")) {
      return ResponseEntity(mapOf("reason" to ex.localizedMessage), HttpStatus.BAD_REQUEST)
    }
    throw ex
  }

  @ExceptionHandler(UnauthorizedException::class)
  fun handle(ex: UnauthorizedException): ResponseEntity<Map<String, String>> {
    if (ex.localizedMessage.startsWith("[todos")) {
      return ResponseEntity(mapOf("reason" to ex.localizedMessage), HttpStatus.BAD_REQUEST)
    }
    throw ex
  }
}
