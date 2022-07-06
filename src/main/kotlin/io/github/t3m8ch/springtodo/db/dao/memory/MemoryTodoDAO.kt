package io.github.t3m8ch.springtodo.db.dao.memory

import io.github.t3m8ch.springtodo.db.dao.exceptions.TodoNotFoundException
import io.github.t3m8ch.springtodo.db.dao.interfaces.TodoDAO
import io.github.t3m8ch.springtodo.db.entities.TodoEntity

class MemoryTodoDAO : TodoDAO {
    private val todos = mutableListOf<TodoEntity>()
    private var lastId = 1

    override fun getAll(): Collection<TodoEntity> = todos

    override fun getById(id: Int): TodoEntity = todos
        .asSequence()
        .filter { e -> e.id == id }
        .firstOrNull() ?: throw TodoNotFoundException()

    override fun create(content: String, isCompleted: Boolean): TodoEntity {
        val todo = TodoEntity(lastId++, content, isCompleted)
        todos += todo
        return todo
    }

    override fun update(id: Int, content: String, isCompleted: Boolean): TodoEntity {
        val todo = getById(id)

        todo.content = content
        todo.isCompleted = isCompleted

        return todo
    }

    override fun deleteById(id: Int): TodoEntity {
        val entity = getById(id)
        todos -= entity
        return entity
    }
}
