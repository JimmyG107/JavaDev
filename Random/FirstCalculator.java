import java.util.Scanner;
class fs {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		double fnum, snum, answer;
		System.out.println("Enter the first number:");
		fnum = input.nextDouble();
		System.out.println("Enter the second number:");
		snum = input.nextDouble();
		answer = fnum + snum;
		System.out.println("The sum is :  " + answer);
	}
}