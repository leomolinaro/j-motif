package motif.agot.state;

public class Victory extends Throwable {
	private AgotPlayer winner;

	public Victory (AgotPlayer winner) {
		this.winner = winner;
	}
		
	private static final long serialVersionUID = 7494347063193082428L;

	public AgotPlayer getWinner () {
		return winner;
	}
}