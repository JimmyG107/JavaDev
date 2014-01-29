package bucky.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Layout extends JFrame{
	private JButton lb;
	private JButton cb;
	private JButton rb;
	private FlowLayout layout;
	private Container container;
	
	public Layout(){
		super("Layout App");
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		HandlerClass handler = new HandlerClass();
		lb = new JButton("Left");
		lb.addActionListener(handler);
		add(lb);
		cb = new JButton("Center");
		cb.addActionListener(handler);
		add(cb);
		rb = new JButton("Right");
		rb.addActionListener(handler);
		add(rb);
	}
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==lb){
				layout.setAlignment(FlowLayout.LEFT);
				layout.layoutContainer(container);
			}
			else if(event.getSource()==cb){
				layout.setAlignment(FlowLayout.CENTER);
				layout.layoutContainer(container);
			}
			else if(event.getSource()==rb){
				layout.setAlignment(FlowLayout.RIGHT);
				layout.layoutContainer(container);
			}
		}
	}

}
