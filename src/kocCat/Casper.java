package kocCat;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Casper extends Ghost{
	Random rand = new Random();
	int cons = 10;
	int m = 3;
	int temp;
	int n;
	public Casper(double xPos, double yPos) {
		super(xPos, yPos);
		width = 60;
		height = 60;
		
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw (Graphics g, double x, double y,int W,int N) {
		ImageIcon casper = new ImageIcon("./src/ghost3.png");
		
		if(xVel>W) {
			setDirection();
		}else if(xVel<-W) {
			setDirection();
		}else if(yVel<-W) {
			setDirection();
		}else if(yVel>W) {
			setDirection();
		}
		if((xVel+cons+x+width/2)>(N*W) || (xVel+cons+x-width/2)*(N*W)<0) {
			cons*=-1;
		}
		if((yVel+cons+y+height/2)>(N*W)||(yVel+cons+y-height/2)*(N*W)<0) {
			cons*=-1;
		}
		if (xVel==0) {
			yVel+=cons;
			y+=yVel;
		}else	{
			xVel+=cons;
			x+=xVel;
		}
		
		
		g.drawImage(casper.getImage(),(int)(x-width/2),(int)( y-height/2),width,height, casper.getImageObserver());
	}

	public void setDirection() {
		m = rand.nextInt(4);
		switch(m) {
		case 0:
			yVel = cons/2;
			xVel=0;
			break;
		case 1:
			yVel=0;
			xVel=-cons/2;
			cons*=-1;
			break;
		case 2:
			yVel=-cons/2;
			xVel=0;
			cons*=-1;
			break;
		case 3:
			yVel=0;
			xVel=cons/2;
		}
	}
}	
	
