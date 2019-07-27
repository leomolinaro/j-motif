package com.motif.shared.game;

import java.util.stream.Stream;

import com.motif.shared.endpoint.MotifUser;

public abstract class MotifGame<P extends MotifPlayer> {

	public abstract Stream<P> players();
	
	public P getAnyPlayerByUser(MotifUser user) { return this.getPlayersByUser(user).findAny().get(); }
	
	public Stream<P> getPlayersByUser(MotifUser user) { return this.players().filter(p -> p.getUser() == user); }
	
}
