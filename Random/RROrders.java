import java.util.Scanner;
import java.math.*;

import sun.security.util.BigInt;
class rro {
	public static void main (String args[])throws InterruptedException {
		Scanner input = new Scanner (System.in);
		String str = "";
		int x = 0;
		int w = 0;
		String z = "run";
		String y = "run";
		int d = 0;
		int m = 0;
		boolean boo1 = false;
		boolean boo2 = false;
		boolean debug = false;
		while (z != "stop") {
			System.out.println("Welcome to the McDonald's Random Ordering System.");
			System.out.println("Enter 1 to enter the Order Randomizer, or press 2 to quit.");
			if (debug) {
				System.out.println("waiting for an input");
			}
			str = input.next();
			boo1 = isInt(str);
			if (boo1) {
				if (debug) {
					System.out.println("assigning x");
				}
				x = Integer.parseInt(str);
				boo2 = is1to2(x);

				if (boo2) {
					if (debug) {
						System.out.println("0<x<3");
					}
					if (x == 1) {
						while (y != "stop") {
							System.out.println("Press 1 for an order, or 2 to go back.");
							str = input.next();
							boo1 = isInt(str);
							if (boo1) {
								x = Integer.parseInt(str);
								boo2 = is1to2(x);
								if (boo2) {
									if (x == 1) {
										String word = " a ";
										String[] a = {
											"1/3-Pound ",
											"Angus ",
											"1/2-Pound ",
											"Grilled Chicken ",
											"Angus Deluxe ",
											"Double Cheese"
										};
										String[] b = {
											" ketchup ",
											" mustard ",
											" cheese and ketchup ",
											" cheese and mustard ",
											" cheese and mayonaise ",
											" mayonaise "
										};
										String[] c = {
											" small fries.",
											" medium fries.",
											" large fries.",
											" a snack-size McFlurry.",
											" a regular-size McFlurry.",
											" an apple pie."
										};
										int inta = a.length;
										int intb = b.length;
										int intc = a.length;
										int ra = (int) (Math.random() * inta);
										int rb = (int) (Math.random() * intb);
										int rc = (int) (Math.random() * intb);
										if ((ra == 1) || (ra == 4)) {
											word = " an ";
										}
										String order = "Hello, I'd like" + word + a[ra] + "burger with" + b[rb] + "and a side of" + c[rc];
										System.out.println(order);
									}
									else if (x == 2) {
										y = "stop";
										x = 0;
									}
								}
								else {
									System.out.println("That is not a valid input!");
									Thread.sleep(1000);
									System.out.println("");
									input.nextLine();
								}
							}
							else {
								System.out.println("That is not a valid input!");
								Thread.sleep(1000);
								System.out.println("");
								input.nextLine();
							}
						}
					}
					else if (x == 2) {
						z = "stop";
					}
				}
				else {
					if (debug) {
						System.out.println("0<!x<!3");
					}
					System.out.println("That is not a valid input!");
					Thread.sleep(1000);
					System.out.println("");
				}
			}
			else {
				if (debug) {
					System.out.println("not a #");
				}
				System.out.println("That is not a valid input!");
				Thread.sleep(1000);
				System.out.println("");
			}
		}
		System.out.println("Goodbye!");
	}
	public static boolean isInt (String str)throws NumberFormatException {
		boolean isint = true;
		if (str == null) {
			isint = false;
		}
		int length = str.length();
		if (length == 0) {
			isint = false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				isint = false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				isint = false;
			}
		}
		if (isint) {
			BigInteger y = new BigInteger(str);
			isint = is1to2(y.intValue());
		}
		return isint;
	}
	public static boolean is1to2(int x) {
		if (x < 1 || x > 2) {
			return false;
		}
		else {
			return true;
		}
	}
}