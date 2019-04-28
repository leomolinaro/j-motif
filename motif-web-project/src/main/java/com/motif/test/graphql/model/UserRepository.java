package com.motif.test.graphql.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class UserRepository {

    private final MongoCollection<Document> users;

    public UserRepository(MongoCollection<Document> users) {
        this.users = users;
    }
    
    public User findByEmail(String email) {
        var doc = users.find(Filters.eq("email", email)).first();
        return user(doc);
    }

    public User findById(String id) {
        var doc = users.find(Filters.eq("_id", new ObjectId(id))).first();
        return user(doc);
    }
    
    public List<User> getAllUsers() {
    	var allUsers = new ArrayList<User>();
        for (var doc : users.find()) {
        	allUsers.add(user(doc));
        }
        return allUsers;
    }
    
    public User saveUser(User user) {
        var doc = new Document();
        doc.append("name", user.getName());
        doc.append("email", user.getEmail());
        doc.append("password", user.getPassword());
        users.insertOne(doc);
        return new User(
                doc.get("_id").toString(),
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }
    
    private User user(Document doc) {
	    if (doc == null) {
	        return null;
	    }
	    return new User(
	            doc.get("_id").toString(),
	            doc.getString("name"),
	            doc.getString("email"),
	            doc.getString("password"));
    }

	public User deleteUser(String id) {
		User toDelete = this.findById(id);
		users.deleteOne(Filters.eq("_id", new ObjectId(id)));
		return toDelete;
	}
}
