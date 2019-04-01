package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ash extends Ghost {
	
	
	public Ash(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=15;
		yVel=0;
		
		// TODO Auto-generated constructor stub
	}
	public void draw (Graphics g, int x, int y) {
		ImageIcon ash = new ImageIcon("./src/ghost1.png");
		int width = 60;
		int height = 60;
		g.drawImage(ash.getImage(), x-width/2, y-height/2,width,height, ash.getImageObserver());
	}
	/*@Override
	public void move (Graphics g, int x, int y) {
		
	}*/
}
