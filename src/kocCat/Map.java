package kocCat;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Map extends JPanel{
	public int W = 84;
	public int N = 10;
	private int f;
	private int p;
	private int g;
	private ArrayList<Poison> pois= new ArrayList<Poison>();
	private ArrayList<Fruit> frui= new ArrayList<Fruit>();
	
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
		while(pois.size()<6) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			System.out.println(xp +" a " + yp);

			for(Poison temp: pois) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					System.out.println(xp + " " + yp +" a");
				}
			}
			for(Fruit temp: frui) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
				}
				
				
			}
			Poison poison = new Poison(xp,yp);
			System.out.println("bob");
			pois.add(poison);
			
		}
		for(int i=0;i<6;i++) {
			pois.get(i).draw(g, W*pois.get(i).getxPos()+W/2,  W*pois.get(i).getyPos()+W/2);
		}
		while(frui.size()<6) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			System.out.println(xp +" a " + yp);

			for(Poison temp: pois) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					System.out.println(xp + " " + yp +" a");
				}
			}
			for(Fruit temp: frui) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
				}
				
				
			}
			Fruit fruit = new Fruit(xp,yp);
			System.out.println("bob");
			frui.add(fruit);
			
		}
		for(int i=0;i<6;i++) {
			frui.get(i).draw(g, W*frui.get(i).getxPos()+W/2,  W*frui.get(i).getyPos()+W/2);
		}
		/*int xp = random.nextInt(N) ;
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
		
		for(int i=0; i<f; i++) {
			xp = random.nextInt(N) ;
			yp = random.nextInt(N) ;
			poison.draw(g, W*xp+W/2, W*yp+W/2);
		}*/
		
		
		
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
