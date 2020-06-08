package com.briantical.Routes

import com.briantical.Tests
import com.briantical.database
import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.request.receive
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.routing.*
import org.litote.kmongo.MongoOperator.set
import org.litote.kmongo.updateOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.replaceOneById
import org.litote.kmongo.updateOneById

fun Route.testroutes(){
    val testsCollection = database.getCollection<Tests>()
    route("/tests"){
        get("/"){
            val tests = testsCollection
                            .find()
                            .toList()
            call.respond(HttpStatusCode.OK, tests )
        }

        post("/"){
            val test = call.receive<Tests>()
            testsCollection.insertOne(test)
            call.respond(HttpStatusCode.Created, "Tests have been inserted")
        }

        put("/{id}"){
            val _id: String = call.parameters["id"] ?: throw IllegalArgumentException("Parameter id not found")
//            val test = Gson().toJson(call.receive<Tests>())
            val  test = call.receive<Tests>()
            println(_id)
//            testsCollection.updateOne("{_id: \"$id\"}","{$set: $test}")
//            testsCollection.updateOneById(_id,test)
            testsCollection.replaceOneById(_id, test)
            call.respond(HttpStatusCode.NoContent, "Update made")
        }

        patch("/"){
            call.respond(HttpStatusCode.NoContent)
        }
    }
}
