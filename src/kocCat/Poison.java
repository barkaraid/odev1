package kocCat;
import java.awt.*;

public class Poison extends Food{
	@Override
	public void draw (Graphics g, int x, int y) {
		int width = 10;
		int height = 10;
		g.drawRect(x, y, width, height);
		
	}
	@Override
	public void grow (Graphics g) {
		
	}
	
}
