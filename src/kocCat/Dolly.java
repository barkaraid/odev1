package kocCat;
import java.awt.*;

import javax.swing.ImageIcon;

public class Dolly extends Ghost{
	public Dolly(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	public void draw (Graphics g, int x, int y) {
		ImageIcon dolly = new ImageIcon("./src/ghost2.png");
		int width = 80;
		int height = 80;
		g.drawImage(dolly.getImage(), x-width/2, y-height/2,width,height, dolly.getImageObserver());
	}
}
