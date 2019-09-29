package kocCat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class KocCat extends Drawable {
	int xVel;
	int yVel;
	int cons = 10;
	String str = "left";
	public KocCat(double xPos, double yPos) {
		super(xPos, yPos);
		xVel=-cons/2;
		yVel=0;
		width = 80;
		height = 80;
		// TODO Auto-generated constructor stub
	}

	public void draw (Graphics g, double x, double y, int W, int N) {
		ImageIcon catL = new ImageIcon("./src/image_"+str+".png");
		
		if(yVel>W) {
			yVel=cons/2;
		}
		if(yVel<-W) {
			yVel=-cons/2;
		}

		if(xVel>W) {
			xVel=cons/2;
		}
		if(xVel<-W) {
			xVel=-cons/2;
		}
		if((xVel+cons+x+width/2)>(N*W) || (xVel+cons+x-width/2)*(N*W)<0) {
			cons=0;
		}
		if((yVel+cons+y+height/2)>(N*W)||(yVel+cons+y-height/2)*(N*W)<0) {
			cons=0;
		}
		
		if(str.equals("left")) {
			xVel-=cons;
			x+=xVel;
		}
		if(str.equals("right")) {
			xVel+=cons;
			x+=xVel;
		}
		if(str.equals("up")) {
			yVel-=cons;
			y+=yVel;
		}
		if(str.equals("down")) {
			yVel+=cons;
			y+=yVel;
		}
	
		
		
		g.drawImage(catL.getImage(), (int)(x-width/2), (int)(y-height/2),width,height, catL.getImageObserver());
	}

	
}
