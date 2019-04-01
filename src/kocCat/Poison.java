package kocCat;
import java.awt.*;

public class Poison extends Food{
	private int age = 1;
	int width = 8;
	int height = 6;
	public Poison(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw (Graphics g, int x, int y) {
		
		
		if(age<10) {
			g.setColor(Color.YELLOW);
		}else if(age>=10) {
			g.setColor(Color.RED);
		}
		if(age<20) {
			width+=4;
			height+=3;
		}
		age++;
		
	}
	@Override
	public void grow (Graphics g, int x, int y) {
		g.clearRect(x-width/2, y-height/2, width, height);
		if(age<10) {
			g.setColor(Color.YELLOW);
		}else if(age>=10) {
			g.setColor(Color.RED);
		}
		if(age<20) {
			width+=4;
			height+=3;
		}
		age++;
	}
	
	
}
