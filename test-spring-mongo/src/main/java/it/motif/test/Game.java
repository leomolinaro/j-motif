package it.motif.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
public class Game {
	
	@Id
	String id;
	int nPlayers = 3;
	String name = "Game";

}
