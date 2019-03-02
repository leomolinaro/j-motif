package motif.test;

import org.bson.Document;

import com.mongodb.MongoClient;

public class MongoDb {

	public static void main(String[] args) {
		var mongoClient = new MongoClient("localhost", 27017);
		
		var motifDb = mongoClient.getDatabase("motif");
		var brit = motifDb.getCollection("brit");
		
		
		brit.insertOne(new Document("title", "prova")
				.append("aaa", "aaa")
				.append("bbb", 1)
		);
		
		mongoClient.close();
	}

}
