package com.example;


import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {

    private static MongoCollection myCollection;

    public static void main(String[] args) {
        MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = client.getDatabase("myDB");
        System.out.println(database);
        myCollection = database.getCollection("persons");
        //myCollection.insertOne(new Document().append("first_name", "Theo").append("last_name", "Malatestas"));
        MongoCursor cursor = myCollection.find().cursor();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}