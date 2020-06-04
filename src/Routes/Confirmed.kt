package com.briantical.Routes

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.confirmedroutes(){
    route("/confirmed"){
        get("/"){
            call.respond(HttpStatusCode.OK, "summary")
        }

        post("/"){
            call.respond(HttpStatusCode.Created, "created summary")
        }

        put("/"){
            call.respond(HttpStatusCode.NoContent)
        }

        patch("/"){
            call.respond(HttpStatusCode.NoContent)
        }
    }
}