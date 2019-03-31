package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Casper extends Ghost{
	public Casper(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	public void draw (Graphics g, int x, int y) {
		ImageIcon casper = new ImageIcon("./src/ghost3.png");
		int width = 80;
		int height = 80;
		g.drawImage(casper.getImage(), x-width/2, y-height/2,width,height, casper.getImageObserver());
	}
}
