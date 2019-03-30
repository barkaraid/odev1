package kocCat;
import javax.swing.*;
import java.awt.*;

public abstract class Drawable  {
	public int xPos, yPos;
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void draw(Graphics g, int x, int y) {
	}

	public Drawable(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
}
