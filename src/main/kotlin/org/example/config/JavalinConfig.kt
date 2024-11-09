package org.example.config

import io.javalin.Javalin
import org.example.controllers.HealthTrackerController


class JavalinConfig {
    fun startJavalinService(): Javalin {
        val app = Javalin.create()
            .apply{
                exception(Exception::class.java) { e, ctx ->e.printStackTrace()}
                error(404) { ctx -> ctx.json("404 - Not Found") }
            }
            .start(7001)
        registerRoutes(app)
        return app
    }

    private fun registerRoutes(app: Javalin) {
        app.get("/api/users", HealthTrackerController::getAllUsers)
        app.get("/api/users/{user-id}", HealthTrackerController::getUserById)
        app.post("/api/users", HealthTrackerController::addUser)
    }
}