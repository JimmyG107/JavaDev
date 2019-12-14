package minesweeper;

import javax.swing.JLabel;

public class GridSquare extends JLabel {
	private static final long serialVersionUID = -3730369173152757620L;
	
	private int x, y;
	private boolean marked, revealed;
	private int surroundingBombs;

	public GridSquare(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		marked = false;
		revealed = false;
		surroundingBombs = 0;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean isMarked) {
		marked = isMarked;
	}
	
	public void toggleMarked() {
		marked = (marked) ? false : true;
	}
	
	public boolean isRevealed() {
		return revealed;
	}
	
	public void setRevealed(boolean isRevealed) {
		revealed = isRevealed;
	}

	public int getBombs() {
		return surroundingBombs;
	}

	public void setBombs(int bombs) {
		surroundingBombs = bombs;
	}
}
