

public class Player {
	Square[][] myShipsGrid;
	private int guessX;
	private int guessY;
	private Square[] ship1;
	private Square[] ship2;
	private Square[] ship3;
	private Square[] ship4;
	private Square[] ship5;
	public Player(){
		myShipsGrid = new Square[10][10];
		ship1 = new Square[2];
		ship2 = new Square[3];
		ship3 = new Square[3];
		ship4 = new Square[4];
		ship5 = new Square[5];
		
	}
	public void setUpGrid() {
		
	}
	public int[] getGuessAndFire() {
		
		
		return new int[]{guessX, guessY};
	}
	public boolean checkSquare(int[] guess) {
		if(myShipsGrid[guess[0]][guess[1]].getHasShip()){
			
			return true;
		}
		else return false;
	}
}
