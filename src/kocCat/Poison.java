package kocCat;
import java.awt.*;

public class Poison extends Food{
	public Poison(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw (Graphics g, int x, int y) {
		
		int width = 8;
		int height = 6;
		
		while(true) {
			if(width<=28) 
				g.setColor(Color.YELLOW);
			if(width>28)
				g.setColor(Color.RED);
			g.fillRect(x-width/2, y-height/2, width, height);
			if(width >= 64) break;
			width+=4;
			height+=3;
		}
		
	}
	@Override
	public void grow (Graphics g) {
		
	}
	
	
}
