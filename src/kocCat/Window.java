package kocCat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class Window extends JFrame {
	
	private JLabel fruit;
	private JLabel poison;
	private JLabel ghost;
	private JTextField frame1;
	private JTextField frame2;
	private JTextField frame3;
	private JButton start;
	public int f,g,p;
	
	public int getF() {
		return f;
	}

	public int getG() {
		return g;
	}

	public int getP() {
		return p;
	}

	public Window() {
		super();
		setLayout(new FlowLayout());

		fruit = new JLabel ("Number of fruits: ");
		fruit.setSize(30, 10);
		fruit.setLocation(10, 10);
		add(fruit);
		frame1= new JTextField(5);
		add(frame1);
		poison = new JLabel ("Number of poisons: ");
		poison.setLocation(10, 30);
		add(poison);
		frame2 = new JTextField(5);
		add(frame2);
		ghost = new JLabel ("Number of ghosts: ");
		ghost.setLocation(10, 50);
		add(ghost);
		frame3 = new JTextField(5);
		add(frame3);
		start = new JButton("start");
		ButtonHandler handle = new ButtonHandler();
		add(start);
		start.addActionListener(handle);
		
	}

	private class ButtonHandler implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent event) {
			
			
			f = Integer.parseInt(frame1.getText());
			p = Integer.parseInt(frame2.getText());
			g = Integer.parseInt(frame3.getText());
			
			
			if(p>0 && f>0 && p>0) {
				Everything done = new Everything(f,p,g);

				done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				done.setSize(900,900);
				done.setVisible(true);
			}
			else {
				System.out.println("Invalid values");
				System.out.println("number of fruits poisons and ghosts"
						+ " must be larger than 0");
				throw new IllegalArgumentException();
			}
		}
	}
}