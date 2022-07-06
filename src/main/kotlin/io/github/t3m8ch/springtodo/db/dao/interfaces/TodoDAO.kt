package io.github.t3m8ch.springtodo.db.dao.interfaces

import io.github.t3m8ch.springtodo.db.entities.TodoEntity

interface TodoDAO {
    fun getAll(): Collection<TodoEntity>
    fun getById(id: Int): TodoEntity
    fun create(content: String, isCompleted: Boolean = false): TodoEntity
    fun update(id: Int, content: String, isCompleted: Boolean): TodoEntity
    fun deleteById(id: Int): TodoEntity
}
