package motif.agot.test;

import motif.agot.state.AgotPlayer;

@Deprecated
public class TPlayer {

	private AgotPlayer player;

	public TPlayer (AgotPlayer player) {
		this.player = player;
	} // TPlayer

	public AgotPlayer getPlayer () {
		return player;
	}
	
} // TPlayer
