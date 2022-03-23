package wando.csa.inheritance;

public class Yorkshire extends Dog {
	private static int breedWeight = 25;
	
	public Yorkshire(String name) {
		super(name);
	}
	
	public String speak() {
		return "woof";
	}
	
	public int avgBreedWeight() {
		return breedWeight;
	}
}
