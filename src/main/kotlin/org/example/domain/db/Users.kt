package org.example.domain.db

import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100)
    val email = varchar("email", 100)
    override val primaryKey = PrimaryKey(id, name = "PK_Users_Id")

}