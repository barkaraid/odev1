package kocCat;
import java.awt.*;

public class Poison extends Food{
	@Override
	public void draw (Graphics g, int x, int y) {
		int width = 0;
		int height = 0;
		g.drawRect(x, y, width, height);
	}
	@Override
	public void grow (Graphics g) {
		
	}
}
