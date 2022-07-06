package io.github.t3m8ch.springtodo

import io.github.t3m8ch.springtodo.db.dao.interfaces.TodoDAO
import io.github.t3m8ch.springtodo.db.dao.memory.MemoryTodoDAO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {
    @Bean
    fun todoDAO(): TodoDAO {
        return MemoryTodoDAO()
    }
}
