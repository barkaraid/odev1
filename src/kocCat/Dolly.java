package kocCat;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Dolly extends Ghost{
	int cons = 10;
	public Dolly(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=0;
		yVel=cons/2;
		width = 60;
		height = 60;
		// TODO Auto-generated constructor stub
	}
	public void draw (Graphics g, double x, double y,int W,int N) {
		ImageIcon dolly = new ImageIcon("./src/ghost2.jpg");
		
		if(yVel>W) {
			yVel=cons/2;
		}
		if(yVel<-W) {
			yVel=-cons/2;
		}
		if((yVel+cons+y+height/2)>(N*W)||(yVel+cons+y-height/2)*(N*W)<0) {
			cons*=-1;
		}
		yVel+=cons;
		y+=yVel;
		g.drawImage(dolly.getImage(), (int)(x-width/2), (int)(y-height/2),width,height, dolly.getImageObserver());
		
		
	}
}
