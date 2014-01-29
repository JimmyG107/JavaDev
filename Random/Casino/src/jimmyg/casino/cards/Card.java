package jimmyg.casino.cards;

public class Card {
	private String suit;
	private int number;
	public Card(String theSuit, int theNumber){
		this.suit = theSuit;
		this.number=theNumber;
	}
	public String getSuit(){
		return suit;
	}
	public int getNumber(){
		return number;
	}
	@Override
	public String toString(){
		String[] numbers = {"Ace of ","Deuce of ","Three of ","Four of ","Five of ","Six of ","Seven of ","Eight of ","Nine of ","Ten of ","Jack of ","Queen of ","King of "};
		return numbers[(number)]+suit;
		
	}
}
