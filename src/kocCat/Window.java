package kocCat;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Window extends JFrame {
	private final JLabel fruit;
	private final JLabel poison;
	private final JLabel ghost;
	private final JTextField frame1;
	private final JTextField frame2;
	private final JTextField frame3;
	private final JButton start;
	
	public Window() {
		super();
		setLayout(new GridLayout(2,4));
		
		fruit = new JLabel ("Number of fruits: ");
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
		add(start);
	}
}
