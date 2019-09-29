package kocCat;
import java.awt.*;

public class Poison extends Food{
	private double age = 1;
	int width = 6;
	int height = 4;
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
			g.clearRect(x-width/2, y-height/2, width, height);
			width+=3;
			height+=2;
			
		}
		g.fillRect(x-width/2, y-height/2, width, height);
		age+=1;
		
	}
	
	
	
}
