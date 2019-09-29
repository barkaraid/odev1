package kocCat;

import java.awt.*;
import java.util.Random;
import java.util.Timer;

public class Fruit extends Food{
	Random random = new Random();
	private double age=1;
	public Fruit(double xPos, double yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	public int a=10;
	@Override
	public void draw(Graphics g , int x , int y, int N) {
		if(age<5) {
			g.setColor(Color.BLUE);
		}else if(age>=5) {
			g.setColor(Color.GREEN);
		}
		if(age<10) {
			//g.clearRect(x-a/2, y-a/2, a, a);
			a+=1.5;
			g.fillOval(x-a/2, y-a/2, a, a);
		}
		age+=0.25;
		if(age>=10) {
			age=1;
			a=10;
			xPos=random.nextInt(N);
			yPos=random.nextInt(N);
		}
		
	}
	
	
}
