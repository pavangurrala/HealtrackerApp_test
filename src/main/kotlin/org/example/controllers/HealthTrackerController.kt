package org.example.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.example.domain.User
import org.example.domain.repository.UserDAO
import io.javalin.http.Context

object HealthTrackerController {
    private val userDao = UserDAO()

    fun getAllUsers(ctx: Context) {
        ctx.json(userDao.getAll())
    }
    fun getUserById(ctx: Context) {
        val id = ctx.pathParam("user-id").toInt()
        val user = userDao.findById(id)
        if (user != null) {
            ctx.json(user)
        }
    }
    fun addUser(ctx: Context) {
        val mapper = jacksonObjectMapper()
        val user = mapper.readValue<User>(ctx.body())
        userDao.save(user)
        ctx.json(user)
    }
}