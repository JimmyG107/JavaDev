package justcause;
import java.util.Random;
import java.util.Scanner;
public class CustomRandomNumber {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers to test?");
		int nums = input.nextInt();//set how many numbers in the array
		int numbers[]=new int[nums];//make an array of numbers with <input> values
		for (int counter = 0; counter < nums; counter++) {
			Random number = new Random();
			numbers[counter] = number.nextInt(6) + 1;
		}//make all the numbers in the array
		double num1s = 0;
		double num2s = 0;
		double num3s = 0;
		double num4s = 0;
		double num5s = 0;
		double num6s = 0;//make our 'counter' variables
		
		for (int counter = 0; counter < nums; counter++) {
			switch (numbers[counter]) {
			case 1 :  num1s++;
			break;
			case 2 :  num2s++;
			break;
			case 3 :  num3s++;
			break;
			case 4 :  num4s++;
			break;
			case 5 :  num5s++;
			break;
			case 6 :  num6s++;
			break;
			}
		}//count # of 1's,2's, and so on
		double per1 = num1s/nums*100;
		double per2 = num2s/nums*100;
		double per3 = num3s/nums*100;
		double per4 = num4s/nums*100;
		double per5 = num5s/nums*100;
		double per6 = num6s/nums*100;//calculate percentages

		System.out.println(per1 + "% are 1's");
		System.out.println(per2 + "% are 2's");
		System.out.println(per3 + "% are 3's");
		System.out.println(per4 + "% are 4's");
		System.out.println(per5 + "% are 5's");
		System.out.println(per6 + "% are 6's");//print results
		input.close();
	}//end Main
}//end CustomRandomNumber