package com.motif.brit.state;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;

public class BritDatabase {
	
	public void insert(BritGame game) {
		var mongoClient = new MongoClient("localhost", 27017);
		var motifDb = mongoClient.getDatabase("motif");
		var brit = motifDb.getCollection("brit");
		var gameDoc = getDoc(game);
		gameDoc.append("name", "Brit");
		brit.insertOne(gameDoc);
		mongoClient.close();
		ObjectId id = gameDoc.getObjectId("_id");
		game.setId(id);
	}
	
	public void update(BritGame game) {
		var mongoClient = new MongoClient("localhost", 27017);
		var motifDb = mongoClient.getDatabase("motif");
		var brit = motifDb.getCollection("brit");
		Document query = new Document();
		query.put("name", "Brit");
		var gameDoc = getDoc(game);
		Document update = new Document();
		update.put("$set", gameDoc);
		brit.updateOne(query, update);
		mongoClient.close();
	}
	
	private Document getDoc(BritGame game) {
		var doc = new Document();
		doc.append("roundNumber", game.getRoundNumber());
		return doc;
	}
	
}
