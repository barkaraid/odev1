package kocCat;

import java.awt.*;

public class Fruit extends Food{
	
	public Fruit(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	public int a=5;
	@Override
	public void draw(Graphics g , int x , int y) {
		while(true) {
			if(a<=30)
				g.setColor(Color.BLUE);
			if(a>30)
				g.setColor(Color.GREEN);
			g.fillOval(x-a/2, y-a/2, a, a);
			if(a==65) break;
			g.clearRect(x-a/2, y-a/2, a, a);
			a++;
			
		}
	}
	@Override
	public void grow (Graphics g) {
		
	}
	
}
