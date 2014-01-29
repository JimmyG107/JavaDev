public class X_is_5 {
	public static void main (String[] args) throws InterruptedException {
		int x;
		x = 5;
			if (x <= 5) {
				System.out.println("x is 5 or less"); }
			else if (x >= 20) {
				System.out.println("x is 20 or more"); }
			else {
				System.out.println("x is between 5 and 20"); } 
			Thread.sleep(1000);
		System.out.println("Let me think for a second or two...");
		Thread.sleep(2000);
		System.out.println("x is " + x);
	}
}