package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ash extends Ghost {
	int cons = 10;
	
	public Ash(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=cons/2;
		yVel=0;
		width = 60;
		height = 60;
		// TODO Auto-generated constructor stub
	}
	public void draw (Graphics g, double x, double y,int W,int N) {
		ImageIcon ash = new ImageIcon("./src/ghost1.png");
		
		
		if(xVel>W) {
			xVel=cons/2;
		}
		if(xVel<-W) {
			xVel=-cons/2;
		}
		if((xVel+cons+x+width/2)>(N*W) || (xVel+cons+x-width/2)*(N*W)<0) {
			cons*=-1;
		}
		xVel+=cons;
		x+=xVel;
		
		g.drawImage(ash.getImage(), (int)(x-width/2),(int)( y-height/2),width,height, ash.getImageObserver());
		
		
	}
	
}
