package minesweeper;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class MinesweeperTestDrive {
	public static void main(String[] args) {
		SetupWindow setup = new SetupWindow();
		setup.setBounds(860, 415, 250, 180);
		setup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setup.setVisible(true);
		int[] values = setup.getValues();
		WindowEvent closingEvent = new WindowEvent(setup, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
		System.out.printf("Width: %d \nHeight: %d \nBombs: %d\n",values[0], values[1], values[2]);
		Minesweeper minesweeper = new Minesweeper(values[0],values[1],values[2]);
	}
}
