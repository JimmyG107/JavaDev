package jimmyg.casino.cards;
import java.util.ArrayList;
import java.util.Random;

public class CardDeck {
	private ArrayList<Card> theDeck;
	public CardDeck(){
		theDeck = new ArrayList<Card>(52);
		String[] suits = {"Diamonds", "Clubs","Hearts","Spades"};
		for(int counter = 0; counter<4; counter++){
			for (int counter2 = 0; counter2<13; counter2++){
				theDeck.add(new Card(suits[counter], counter2));
			}
		}
	}
	public void printArrayListDeck(){
		for(int counter = 0;counter<theDeck.size();counter++){
			System.out.println(theDeck.get(counter).toString());
		}
	}
	public static String[][][] resetDeck(String[][][] deck) {
		String[] numbers = {"Ace of ","Deuce of ","Three of ","Four of ","Five of ","Six of ","Seven of ","Eight of ","Nine of ","Ten of ","Jack of ","Queen of ","King of "};
		String[] suits = {"Diamonds", "Clubs","Hearts","Spades"};
		for (int counter = 0; counter < 4; counter++) {
			for (int counter2=0;counter2<13;counter2++){
				deck[0][counter][counter2] = numbers[counter2]
						+suits[counter];
				deck[1][counter][counter2] = "not drawn";
			}
		}
		return deck;
	}
	public static void printDeck(String[][][] deck) {
		int suit = 0;
		for (String[][] carddeck : deck) {
			if (true) {
				for (String[] suits : carddeck) {
					int number = 1;
					for (String card : suits) {
						if (suit>0) {
							System.out.print(card+"\t\t");
						}else {
							if (number==1||number==6||number==10) {
								System.out.print(card+"\t\t");
								number++;
							}
							else {
								System.out.print(card+"\t");
								number++;
							}
						}
					}
					suit++;
					System.out.println("");
				}
			}
		}
	}
	public static int[] drawCard(String[][][] deck){
		Random rand = new Random();
		int suit = 0;
		int card = 0;
		int condition = 0;
		do {
			condition = 0;
			suit = rand.nextInt(3);
			card = rand.nextInt(13);
			if ((deck[1][suit][card]) == "not drawn") {
				condition = 1;
			}
		}while(condition == 0);
		int[] cardFin = {suit, card};
		return cardFin;
	}
	public static void getDrawn(String[][][] deck) {
		String word1 = "Nothing ";
		String word2 = "has ";
		String[] drawn = new String[52];
		int drawnNum = 0;
		for (int counter = 0; counter<52; counter++) {
			drawn[counter] = "";
		}
		int cardNum = 0;
		for(int suit = 0; suit < 4; suit++){
			for(int card = 0; card < 13; card++) {
				if (deck[1][suit][card] == "drawn") {
					word1 = "The ";
					word2 = "have ";
					drawn[cardNum] = deck[0][suit][card];
					cardNum++;
					drawnNum++;
				}
			}
		}
		System.out.print(word1);
		for (int counter = 0; counter < drawnNum; counter++) {
			System.out.print(drawn[counter]);
			if (drawnNum-counter != 1) {
				System.out.print(", ");
			}
			else System.out.print(" ");
			if (drawnNum-counter == 2) {
				System.out.println("and ");
			}
		}
		System.out.println(word2+"been drawn.");
	}
}
