package wando.csa.inheritance;

import java.util.*;

public class Essay extends TestQuestion {
	private int blankLines;
	
	public void readQuestion(Scanner input) {
		this.blankLines = input.nextInt();
		input.nextLine();
		super.setQuestion(input.nextLine());
	}
	
	public String toString() {
		String ret = super.toString() + "\n";
		
		for (int i = 0; i < blankLines; i++) {
			ret += "______________________________" + "\n";
		}
		
		return ret;
	}
}
