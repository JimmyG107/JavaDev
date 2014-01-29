package bucky.polymorphism;

public class AnimalList {
	private Animal[] thelist = new Animal[5];
	private int i = 0;
	
	public void add(Animal a) {
		if(i<thelist.length){
			thelist[i] = a;
			System.out.println(a.getTypeAnimal(a)+" "+a.getName(a)+" at "+a.getAge(a)+" years old has been added at index "+i);
			i++;
		}
		else {
			System.out.println("The array is already full!");
		}
	}

}
