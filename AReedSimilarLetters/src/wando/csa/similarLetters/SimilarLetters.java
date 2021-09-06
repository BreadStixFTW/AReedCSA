package wando.csa.similarLetters;

/*
 * Programmer: Alex Reed
 * Date: 9/6/2021
 * Purpose: Print out letters to various people that contain a similar paragraph.
 */

public class SimilarLetters {
	public static void sameParagraph() {
		System.out.println("Hey, how are you doing? I have been doing well, and everything going on with me is normal and not crazy.");
	}
	
	public static void letterToFriend() {
		System.out.println("Hey Josh,");
		sameParagraph();
		System.out.println("I was wondering if you wanted to go on a skiing trip with me soon in two weeks. Let me know if you want to go. Goodbye!");
		System.out.println("From, Alex");
	}
	
	public static void letterToBrother() {
		System.out.println("Dear Zach,");
		sameParagraph();
		System.out.println("I was wondering when I can visit soon. It has been a while and I am able to travel right now. Goodbye!");
		System.out.println("From, Alex");
	}
	
	public static void letterToMother() {
		System.out.println("Dear Mom,");
		sameParagraph();
		System.out.println("I was able to find a good present to get Zach for his birthday coming up. It will be nice to see his reaction when I give it to him soon. Goodbye!");
		System.out.println("From, Alex");
	}
	
	public static void main(String[] args) {
		letterToFriend();
		System.out.println("");
		letterToBrother();
		System.out.println("");
		letterToMother();
	}
}
