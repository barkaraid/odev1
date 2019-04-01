package kocCat;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Casper extends Ghost{
	Random rand = new Random();
	public Casper(double xPos, double yPos) {
		super(xPos, yPos);
		
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw (Graphics g, int x, int y) {
		ImageIcon casper = new ImageIcon("./src/ghost3.png");
		width = 60;
		height = 60;
		g.drawImage(casper.getImage(), x-width/2, y-height/2,width,height, casper.getImageObserver());
	}
	@Override
	public void move(Graphics g, int x, int y) {
		g.clearRect(x-width/2, y-height/2, width, height);
		setDirection();
		draw(g,x,y);
	}
	public void setDirection() {
		int m = rand.nextInt(20);
		if(m==2) {
			yVel=-15;
			xVel=0;
		}else if(m==4) {
			yVel=0;
			xVel=-15;
		}else if(m==6) {
			yVel=0;
			xVel=15;
		}else if(m==8) {
			yVel=15;
			xVel=0;
		}
	}
	
}
