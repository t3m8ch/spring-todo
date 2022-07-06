package io.github.t3m8ch.springtodo.db.entities

data class TodoEntity(val id: Int, var content: String, var isCompleted: Boolean = false) {
    override fun equals(other: Any?) =
        if (other is TodoEntity) other.id == id
        else super.equals(other)

    override fun hashCode() = id
}
