package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Dolly extends Ghost{
	public Dolly(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=0;
		yVel=15;
		// TODO Auto-generated constructor stub
	}
	public void draw (Graphics g, int x, int y) {
		ImageIcon dolly = new ImageIcon("./src/ghost2.jpg");
		width = 60;
		height = 60;
		g.drawImage(dolly.getImage(), x-width/2, y-height/2,width,height, dolly.getImageObserver());
	}
}
