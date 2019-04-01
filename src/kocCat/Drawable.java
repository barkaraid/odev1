package kocCat;
import javax.swing.*;
import java.awt.*;

public abstract class Drawable  {
	public double xPos, yPos;
	public int width;
	public int height;
	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void draw(Graphics g, int x, int y) {
	}

	public Drawable(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
}
