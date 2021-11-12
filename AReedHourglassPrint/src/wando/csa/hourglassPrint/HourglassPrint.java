package wando.csa.hourglassPrint;

public class HourglassPrint {
	public static void main(String[] args) {
		System.out.println("|\"\"\"\"\"\"\"\"\"|");
		for (int i = 1; i <= 7; i += 2) {
			for (int j = 1; j < i + 2; j += 2) {
				System.out.print(" ");
			}
			
			System.out.print("\\");
			
			for (int j = 7; j >= i; j--) {
				System.out.print(":");
			}
			System.out.println("/");
		}
		
		for (int i = 1; i <= 7; i += 2) {
			for (int j = 7; j > i - 2; j -= 2) {
				System.out.print(" ");
			}
			
			System.out.print("/");
			
			for (int j = 1; j <= i; j++) {
				System.out.print(":");
			}
			System.out.println("\\");
		}
		System.out.println("|\"\"\"\"\"\"\"\"\"|");
	}
}
