package model;

public class GameStatement {
	private int alivePlayer; // if 1 or 0 the game is over.
	private int time;
	private int winner; // value correct only if the game is over

	
	public GameStatement() {
		setAlivePlayer(0);
		time = 0;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}


	/**
	 * @return the winner
	 */
	public int getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(int winner) {
		this.winner = winner;
	}
	/**
	 * @return the alivePlayer
	 */
	public int getAlivePlayer() {
		return alivePlayer;
	}
	/**
	 * @param alivePlayer the alivePlayer to set
	 */
	public void setAlivePlayer(int alivePlayer) {
		this.alivePlayer = alivePlayer;
	}
}
