package bucky.gui;

import static java.awt.BorderLayout.SOUTH;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	private String details;
	private JLabel statusBar;
	
	public Gui(){
		super("tutle");
		
		
		statusBar = new JLabel("this is default");
		add(statusBar, SOUTH);
		addMouseListener(new MouseClass());
	}
	
	private class MouseClass extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			details = String.format("You clicked %d", event.getClickCount());
			if(event.isMetaDown()){
				details+=" with a right mouse button";
			}
			else if(event.isAltDown()){
				details+=" with a middle mouse button";
			}
			else details+=" with a left mouse button";
			statusBar.setText(details);
		}
	}
}
