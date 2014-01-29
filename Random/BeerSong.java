import java.util.Scanner;
class bs {
	public static void main (String[] args)throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int x = 0;
		int z = 0;
		int w = 0;
		boolean debugMode = true;
		double time = 0;
		int time2 = 0;
		String lifeline = "run";
		System.out.println("Welcome to the Beer Song app!");
		while (lifeline != "stop") {
			if (z != 0) {
				input.nextLine();
				if (x == 4) {
					input.nextLine();
					x = 0;
				}
			}
			System.out.println("Options:");
			System.out.println("(Press 1) Edit the time between sentences");
			System.out.println("(Press 2) Play the song!");
			System.out.println("(Press 3) Quit");
			if (input.hasNextInt()) {
				w = input.nextInt();
				if (w > 3) {
					System.out.println("That is not a valid input!");
					Thread.sleep(1000);
				}
				else if (w < 1) {
					System.out.println("That is not a valid input!");
					Thread.sleep(1000);
				}
				else {
					x = w;
					if (x == 1) {
						System.out.println("Enter the time you would like to have between sentences.");
						System.out.println("If you want part-second times, please put it in decimal form.");
						if (input.hasNextDouble()) {
							time = input.nextDouble();
							System.out.println("Sentences will now be " + time + " seconds apart.");
							time = time * 1000;
							time2 = (int)time;
							Thread.sleep(1000);
						}
						else {
							System.out.println("That is not a valid input!");
							Thread.sleep(1000);
							x = 4;
						}
					}
					else if (x == 2) {
						System.out.println("How many bottles of beer are on the wall?");
						if (input.hasNextInt()) {
							int beerNum = input.nextInt();
							String word = "bottles ";
							while (beerNum > 0) {
								if (beerNum == 1) {
									word = "bottle ";
								}
								System.out.println(beerNum + " " + word + "of beer on the wall!");
								Thread.sleep(time2);
								System.out.println(beerNum + " " + word + "of beer!");
								Thread.sleep(time2);
								System.out.println("Take one down, pass it around,");
								Thread.sleep(time2);
								beerNum--;
								if (beerNum == 1) {
									word = "bottle ";
								}
								if (beerNum != 0) {
									System.out.println(beerNum + " " + word + "of beer on the wall!");
									Thread.sleep(time2);
									System.out.println("");
								}
								else {
									System.out.println("No more bottles of beer on the wall!");
									Thread.sleep(1000);
								}
							}
						}
						else {
							System.out.println("That is not a valid input!");
							Thread.sleep(1000);
							x = 4;
						}
					}
					else if (x == 3) {
						lifeline = "stop";
					}
				}
			}
			else {
				System.out.println("That is not a valid input!");
				Thread.sleep(1000);
			}
			z++;
		}
		System.out.println("Bye-bye!");
	}
}