package kocCat;
import java.awt.*;

import javax.swing.ImageIcon;

public class KocCat extends Drawable{
	int xVel;
	int yVel;
	public KocCat(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=-15;
		yVel=0;
		// TODO Auto-generated constructor stub
	}

	public void draw (Graphics g, int x, int y) {
		ImageIcon catL = new ImageIcon("./src/image_left.png");
		int width = 80;
		int height = 80;
		g.drawImage(catL.getImage(), x-width/2, y-height/2,width,height, catL.getImageObserver());
	}
	public void move(Graphics g) {
		
	}
	
}
