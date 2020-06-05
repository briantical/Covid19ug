package com.briantical

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.litote.kmongo.*

const val DATABASE_NAME: String = "covid19ug"

val client = KMongo.createClient()
val database:MongoDatabase = client.getDatabase(DATABASE_NAME)

fun getCollection(collectionName:String): MongoCollection<Document> {
    return database.getCollection(collectionName)
}