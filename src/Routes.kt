package com.briantical

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.apiroutes(){
    route("/api/v1"){
        get("/"){
            call.respond(HttpStatusCode.OK, "Fetched")
        }

        post("/"){
            call.respond(HttpStatusCode.Created)
        }
    }
}