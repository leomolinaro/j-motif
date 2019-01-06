package motif.brit.logic.game;

import motif.brit.flow.IBritAutoIO;
import motif.brit.flow.IBritAutoIOVisitor;
import motif.brit.state.BritGame;

public abstract class ABritPlayIO implements IBritAutoIO {
	
	@Override public void accept(IBritAutoIOVisitor visitor) { visitor.visit(this); }
	
	public abstract BritGame getGame();
	
}
