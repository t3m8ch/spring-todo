package io.github.t3m8ch.springtodo.api.controllers

import io.github.t3m8ch.springtodo.api.dto.todo.CreateUpdateTodoDTO
import io.github.t3m8ch.springtodo.api.dto.todo.TodoOutDTO
import io.github.t3m8ch.springtodo.db.exceptions.TodoNotFoundException
import io.github.t3m8ch.springtodo.db.dao.interfaces.TodoDAO
import io.github.t3m8ch.springtodo.db.entities.TodoEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("todos")
class TodoController(private val todoDAO: TodoDAO) {
    @ExceptionHandler(TodoNotFoundException::class)
    fun handleTodoNotFound(ex: TodoNotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getAll(): Collection<TodoOutDTO> {
        return todoDAO.getAll().map { e -> mapEntityToDTO(e) }
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): TodoOutDTO {
        return mapEntityToDTO(todoDAO.getById(id))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody todo: CreateUpdateTodoDTO): TodoOutDTO {
        return mapEntityToDTO(todoDAO.create(todo.content, todo.isCompleted))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody todo: CreateUpdateTodoDTO): TodoOutDTO {
        return mapEntityToDTO(todoDAO.update(id, todo.content, todo.isCompleted))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int): TodoOutDTO {
        return mapEntityToDTO(todoDAO.deleteById(id))
    }
}

private fun mapEntityToDTO(e: TodoEntity) = TodoOutDTO(e.id, e.content, e.isCompleted)
