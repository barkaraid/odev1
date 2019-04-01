package kocCat;
import java.awt.*;

public class Ghost extends Drawable{
	int xVel;
	int yVel;
	public Ghost(double xPos, double yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	/*public void draw (Graphics g, int x, int y) {
		
	}*/
	public void move(Graphics g, int x, int y) {
		g.clearRect(x-width/2, y-height/2, width, height);
		x+=xVel;
		y+=yVel;
		draw(g,x,y);
		
	}
}
