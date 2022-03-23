package wando.csa.inheritance;

public class DogTest {
	public static void main(String[] args) {
		Labrador lab = new Labrador("Max", "Brown");
		Yorkshire york = new Yorkshire("Terry");
		
		System.out.println(lab.getName() + " says " + lab.speak());
		System.out.println(york.getName() + " says " + york.speak());
		
		System.out.println(lab.avgBreedWeight());
		System.out.println(york.avgBreedWeight());
	}
}
