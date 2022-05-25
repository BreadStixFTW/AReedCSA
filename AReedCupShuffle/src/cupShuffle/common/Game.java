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
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean[] getCups() {
		return this.cups;
	}
	
	public int getScore() {
		return this.score;
	}
}
