package wando.csa.inheritance;

import java.util.*;

public class MultChoice extends TestQuestion {
	private String[] choices;
	
	public void readQuestion(Scanner input) {
		int choiceSize = input.nextInt();
		super.setQuestion(input.nextLine());
		
		choices = new String[choiceSize];
		
		for (int i = 0; i < choices.length; i++) {
			choices[i] = input.nextLine();
		}
	}
	
	public String toString() {
		String ret = super.toString() + "\n";
		
		for (int i = 0; i < choices.length; i++) {
			if (i == choices.length - 1) {
				ret += choices[i];
			}
			else {
				ret += choices[i] + "\n";
			}
		}
		
		return ret;
	}
}
