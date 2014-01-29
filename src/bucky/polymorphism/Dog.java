package bucky.polymorphism;

public class Dog extends Animal{
	
	Dog(String n, int a) {
		this.name = n;
		this.age = a;
		this.animal = "Dog";
	}
	
	public void noise() {
		System.out.println("Woof");
	}
}
