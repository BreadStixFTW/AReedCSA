package wando.csa.inheritance;

import java.util.*;

public class Essay extends TestQuestion {
	private int blankLines;
	
	public void readQuestion(Scanner input) {
		this.blankLines = input.nextInt();
		super.setQuestion(input.nextLine());
	}
	
	public String toString() {
		return blankLines + "\n" + super.toString();
	}
}
