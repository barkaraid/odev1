package kocCat;
import java.awt.*;

import javax.swing.ImageIcon;

public class KocCat extends Drawable{
	public KocCat(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	public void draw (Graphics g, int x, int y) {
		ImageIcon catL = new ImageIcon("./src/image_left.png");
		int width = 80;
		int height = 80;
		g.drawImage(catL.getImage(), x-width/2, y-height/2,width,height, catL.getImageObserver());
	}
	
	
}
