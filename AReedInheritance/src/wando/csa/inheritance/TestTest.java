package wando.csa.inheritance;

import java.util.*;

public class TestTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int testSize = input.nextInt();
		input.nextLine();
		
		TestQuestion[] test = new TestQuestion[testSize];
		
		for (int i = 0; i < test.length; i++) {
			String questionType = input.next();
			
			if (questionType.equals("e")) {
				test[i] = new Essay();
				((Essay) test[i]).readQuestion(input);
			}
			else if (questionType.equals("m")) {
				test[i] = new MultChoice();
				((MultChoice) test[i]).readQuestion(input);
			}
		}
		
		input.close();
		
		for (TestQuestion t : test) {
			System.out.println(t);
		}
	}
}
