package io.github.t3m8ch.springtodo

import io.github.t3m8ch.springtodo.db.dao.interfaces.TodoDAO
import io.github.t3m8ch.springtodo.db.dao.memory.MemoryTodoDAO
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.List


@Configuration
class AppConfiguration {
    @Bean
    fun todoDAO(): TodoDAO {
        return MemoryTodoDAO()
    }

    @Bean
    fun publicUserApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Todos")
            .pathsToMatch("/todos/**")
            .build()
    }

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI().info(
            Info().title("Application API")
                .version("0.0.1")
                .description("Something")
        )
    }
}
