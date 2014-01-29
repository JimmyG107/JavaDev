import java.util.Scanner;

class Counter {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Look, I can count!  Tell me a number, and I'll count up to it!");
		Scanner something = new Scanner(System.in);
		if (something.hasNextInt() != true) {
			System.out.println("That is not a number!");
		}
		else {
			int something2 = something.nextInt();
			for (int counter = 1;counter<=something2;counter++) {

			System.out.println(counter);
			Thread.sleep(1000);
			}
		}
		
	}
}