package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ash extends Ghost {
	public Ash(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	public void draw (Graphics g, int x, int y) {
		ImageIcon ash = new ImageIcon("./src/ghost1.png");
		int width = 80;
		int height = 80;
		g.drawImage(ash.getImage(), x-width/2, y-height/2,width,height, ash.getImageObserver());
	}
	@Override
	public void move (Graphics g, int x, int y) {
		
	}
}
