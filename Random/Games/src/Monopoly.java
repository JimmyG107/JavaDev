import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Monopoly {

	public static void main(String[] args) {
		System.out.println("Welcome to Monopoly!\nHow many people are playing?(including NPCs)");
		Scanner input = new Scanner(JOptionPane.showInputDialog("Welcome to monopoly!\nHow many people are playing?\n(including NPCs)"));
		while(!input.hasNextInt()){
			input = new Scanner(JOptionPane.showInputDialog("That is not a valid input.\nPlease make sure your input is a number\ngreater than 1 and less than 9."));
		}
		input.close();
	}

}
