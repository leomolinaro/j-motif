package it.motif.test;


@Document(collection = "game")
public class Game {
	
	@Id
	String id;
	int nPlayers = 3;
	String name = "Game";

}
