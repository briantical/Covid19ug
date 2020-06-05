package com.briantical.Routes


import com.briantical.Routes.*
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.apiroutes(){
    route("/api/v1"){
        get("/"){
            call.respond(HttpStatusCode.OK, "Fetched")
        }
        testroutes()
        casesroutes()
        reportsroutes()
        summaryroutes()
        confirmedroutes()
        locationsroutes()
        statisticsroutes()
    }
}