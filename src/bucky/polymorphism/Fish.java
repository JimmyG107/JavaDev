package bucky.polymorphism;

public class Fish extends Animal{
	
	Fish(String n, int a){
		this.name = n;
		this.age = a;
		this.animal = "Fish";
	}
	
	public void noise() {
		System.out.println("Glurp Slurp");
	}

}
