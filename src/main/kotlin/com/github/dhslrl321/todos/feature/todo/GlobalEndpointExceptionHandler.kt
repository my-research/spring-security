package com.github.dhslrl321.todos.feature.todo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalEndpointExceptionHandler {

  @ExceptionHandler(IllegalArgumentException::class)
  fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<Map<String, String>> {
    if (ex.localizedMessage.startsWith("[todos")) {
      return ResponseEntity(mapOf("reason" to ex.localizedMessage), HttpStatus.BAD_REQUEST)
    }
    throw ex
  }
}
