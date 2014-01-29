package bucky.polymorphism;

public abstract class Animal {
	protected String name;
	protected int age;
	protected String animal;
	public String getName(Animal a) {
		return a.name;
	}
	public int getAge(Animal a) {
		return a.age;
	}
	public String getTypeAnimal(Animal a){
		return a.animal;
	}
	
	public void noise() {
		System.out.println("Animals don't make noise");
	}
}
