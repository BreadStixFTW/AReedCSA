package wando.csa.blockLetters;

/*
 * Programmer: Alex Reed
 * Date: 9/6/2021
 * Purpose: To print out block letters that spell Mississippi.
 */

public class BlockLetters {
	public static void mBlockLetter() {
		System.out.println("M     M");
		System.out.println("MM   MM");
		System.out.println("M M M M");
		System.out.println("M  M  M");
		System.out.println("M     M");
		System.out.println("M     M");
		System.out.println("M     M");
		System.out.println("");
	}
	
	public static void iBlockLetter() {
		System.out.println(" IIIII ");
		System.out.println("   I   ");
		System.out.println("   I   ");
		System.out.println("   I   ");
		System.out.println("   I   ");
		System.out.println("   I   ");
		System.out.println(" IIIII ");
		System.out.println("");
	}
	
	public static void doubleSBlockLetter() {
		System.out.println(" SSSSS ");
		System.out.println("S     S");
		System.out.println("S      ");
		System.out.println(" SSSSS ");
		System.out.println("      S");
		System.out.println("S     S");
		System.out.println(" SSSSS ");
		
		System.out.println("");
		
		System.out.println(" SSSSS ");
		System.out.println("S     S");
		System.out.println("S      ");
		System.out.println(" SSSSS ");
		System.out.println("      S");
		System.out.println("S     S");
		System.out.println(" SSSSS ");
		System.out.println("");
	}
	
	public static void doublePBlockLetter() {
		System.out.println("PPPPPP ");
		System.out.println("P     P");
		System.out.println("P     P");
		System.out.println("PPPPPP ");
		System.out.println("P      ");
		System.out.println("P      ");
		System.out.println("P      ");
		
		System.out.println("");
		
		System.out.println("PPPPPP ");
		System.out.println("P     P");
		System.out.println("P     P");
		System.out.println("PPPPPP ");
		System.out.println("P      ");
		System.out.println("P      ");
		System.out.println("P      ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		mBlockLetter();
		iBlockLetter();
		doubleSBlockLetter();
		iBlockLetter();
		doubleSBlockLetter();
		iBlockLetter();
		doublePBlockLetter();
		iBlockLetter();
	}
}
