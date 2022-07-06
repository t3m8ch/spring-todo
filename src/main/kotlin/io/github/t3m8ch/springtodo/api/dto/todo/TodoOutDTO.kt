package io.github.t3m8ch.springtodo.api.dto.todo

import io.github.t3m8ch.springtodo.api.dto.ApiDTO

data class TodoOutDTO(val id: Int, val content: String, val isCompleted: Boolean = false) : ApiDTO()
