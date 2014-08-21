package jimmyg.casino.start;

import java.util.Scanner;

import jimmyg.casino.cards.CardDeck;
import jimmyg.casino.games.Slots;

public class Casino {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int money = 1000;
		boolean play = true;
		//System.out.println("Welcome to JimmyG's Virtual Casino!");
		do{
			System.out.println("What game would you like to play?");
			CardDeck theDeck= new CardDeck();
			theDeck.printArrayListDeck();
			Slots.play(money);
		}while(play);
		System.out.println("Goodbye!");
		input.close();
	}
}
