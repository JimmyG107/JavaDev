package justcause;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class TestCalcGUI{
	public static void main(String[] args) {
		
		boolean isDouble=false;
		boolean thru = false;
		Scanner test = new Scanner("");
		double fn = 0;
		double sn = 0;
		int operation = 0;
		double answer = 0;
		String word = "";
		String[] words = {" plus ", " minus ", " times ", " divided by ", " to the power of "};
		
		do {
			if (thru){
				test = new Scanner(JOptionPane.showInputDialog("That is not a valid operation number.  Please enter a valid operation number:\n1 for addition\n2 for subtraction\n3 for multiplication\n4 for division\n5 for exponentials"));
			}
			else {
				test = new Scanner(JOptionPane.showInputDialog("What operation would you like to calculate?\n1 for addition\n2 for subtraction\n3 for multiplication\n4 for division\n5 for exponentials"));
			}
			if (test.hasNextInt()){
				operation = test.nextInt();
				if (operation>=1&&operation<=5) {
					isDouble = true;
				}
			}
			thru = true;
		}while(!isDouble);
		thru = false;
		isDouble = false;
		
		do {
			if (thru){
				test = new Scanner(JOptionPane.showInputDialog("That is not a valid enrty.\nPlease enter a valid number:"));
			}
			else {
				test = new Scanner(JOptionPane.showInputDialog("Enter first number"));
			}
			if (test.hasNextDouble()){
				fn = test.nextDouble();
				isDouble = true;
			}
			thru = true;
			
		}while (!isDouble);
		
		isDouble = false;
		thru = false;
		
		do {
			if (thru){
				test = new Scanner(JOptionPane.showInputDialog("That is not a valid enrty.\nPlease enter a valid number:"));
			}
			else {
				test = new Scanner(JOptionPane.showInputDialog("Enter second number"));
			}
			if (test.hasNextDouble()){
				isDouble = true;
				sn = test.nextDouble();
			}
			thru = true;
		}while (!isDouble);
		
		switch (operation) {
		case 1:answer = fn + sn;break;
		case 2:answer = fn - sn;break;
		case 3:answer = fn * sn;break;
		case 4:answer = fn / sn;break;
		case 5:answer = Math.pow(fn, sn);break;
		}
		System.out.println(5 ^ 2);
		word = words[operation - 1];
		JOptionPane.showMessageDialog(null, fn + word + sn + " equals " + answer, " Simple Addition Calculator GUI", JOptionPane.PLAIN_MESSAGE);
		
	}
}


