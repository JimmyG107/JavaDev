package minesweeper;

import javax.swing.JFrame;

public class MinesweeperTestDrive {
	public static void main(String[] args) {
		SetupWindow setup = new SetupWindow();
		setup.setBounds(860, 415, 250, 180);
		setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Minesweeper minesweeper;
		while (true) {
			setup.setVisible(true);
			int[] values = setup.getValues();
			setup.setVisible(false);
			System.out.printf("Width: %d \nHeight: %d \nBombs: %d\n", values[0], values[1], values[2]);
			minesweeper = new Minesweeper(values[0], values[1], values[2], setup);
			minesweeper.awaitCompletion();
		}
	}
}
