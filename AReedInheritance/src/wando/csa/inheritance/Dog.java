package wando.csa.inheritance;

public abstract class Dog {
	protected String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;	
	}
	
	public String speak() {
		return "Woof";
	}
	
	public abstract int avgBreedWeight();
}
