package minesweeper;

import javax.swing.JLabel;

public class GridSquare extends JLabel {
	private static final long serialVersionUID = -3730369173152757620L;
	boolean marked;
	int surroundingBombs;
	public GridSquare(boolean isMarked, int bombs){
		super();
		marked=isMarked;
		surroundingBombs = bombs;
	}
	public int getBombs(){
		return surroundingBombs;
	}
	public boolean getMarked(){
		return marked;
	}
	public void setBombs(int bombs){
		surroundingBombs=bombs;
	}
	public void setMarked(boolean isMarked){
		marked=isMarked;
	}
}
