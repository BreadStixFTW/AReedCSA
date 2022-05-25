package cupShuffle.common;

public class Game {
	private boolean[] cups;
	private int score;
	
	public Game() {
		this.cups = new boolean[3];
		
		cups[0] = false;
		cups[1] = true;
		cups[2] = false;
	}
	
	public void increaseScore() {
		this.score++;
	}
	
	public void setCups(boolean[] cups) {
		this.cups = cups;
	}
	
	public boolean[] getCups() {
		return this.cups;
	}
	
	public int getScore() {
		return this.score;
	}
}
