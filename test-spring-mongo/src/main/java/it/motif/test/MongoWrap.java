package it.motif.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoWrap {

//	private MongoTemplate mongoTemplate;
	
	@Autowired
    public MongoWrap(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
    }
	
}
