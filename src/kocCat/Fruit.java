package kocCat;

import java.awt.*;

public class Fruit extends Food{
	@Override
	public void draw(Graphics g , int x , int y) {
		int a=0;
		g.drawOval(a,a,x,y);
	}
	@Override
	public void grow (Graphics g) {
		
	}
}
