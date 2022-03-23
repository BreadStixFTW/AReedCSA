package wando.csa.inheritance;

import java.util.*;

public class Essay extends TestQuestion {
	private int blankLines;
	
	public void readQuestion(Scanner input) {
		this.blankLines = input.nextInt();
		input.nextLine();
	}
	
	public String toString() {
		return "" + blankLines;
	}
}
