package kocCat;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Map extends JPanel{
	public int W = 84;
	public int N = 10;
	int f;
	int p;
	int g;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		int xm = 0;
		int ym = 0;
		
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g.drawRect(xm, ym, W, W);
				xm+=W;
			}
			xm=0;
			ym+=W;
		}
		Random random = new Random();
		
		int xp = random.nextInt(N) ;
		int yp = random.nextInt(N) ;
		Food poison = new Poison();
		poison.draw(g, W*xp+W/2, W*yp+W/2);
		
		int xf = random.nextInt(N) ;
		int yf = random.nextInt(N) ;
		while(xf==xp && yf==yp) {
			xf = random.nextInt(N) ;
			yf = random.nextInt(N) ;
		}
		Food fruit = new Fruit();
		fruit.draw(g, W*xf+W/2, W*yf+W/2);
		
		
	}
	public int getMiddlePoint() {
		return (W*N)/2;
	}

	public void setF(int val) {
		f=val;
	}
	public void setP(int val) {
		p=val;
	}
	public void setG(int val) {
		g=val;
	}
	
}
