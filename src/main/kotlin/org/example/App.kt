package org.example

import org.example.config.JavalinConfig
import org.example.config.DbConfig
import org.jetbrains.exposed.sql.Database

fun main() {
    JavalinConfig().startJavalinService()
    DbConfig().getDbConnection()
}