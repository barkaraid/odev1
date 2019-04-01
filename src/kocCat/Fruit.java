package kocCat;

import java.awt.*;
import java.util.Timer;

public class Fruit extends Food{
	private int age=1;
	public Fruit(double xPos, double yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	public int a=10;
	@Override
	public void draw(Graphics g , int x , int y) {
		g.setColor(Color.BLUE);
		g.fillOval(x-a/2, y-a/2, a, a);
		/*while(true) {
			if(a<=30)
				g.setColor(Color.BLUE);
			if(a>30)
				g.setColor(Color.GREEN);
			g.fillOval(x-a/2, y-a/2, a, a);
			if(a==65) break;
			g.clearRect(x-a/2, y-a/2, a, a);
			a++;
			
		}*/
	}
	@Override
	public void grow (Graphics g, int x, int y) {
		if(age<5) {
			g.setColor(Color.BLUE);
		}else if(age>=5) {
			g.setColor(Color.GREEN);
		}
		g.clearRect(x-a/2, y-a/2, a, a);
		a+=5;
		if(age<10) {
			g.fillOval(x-a/2, y-a/2, a, a);
			age++;
		}
	}
	
}
