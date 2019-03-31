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
	private int gho;
	private ArrayList<Poison> pois= new ArrayList<Poison>();
	private ArrayList<Fruit> frui= new ArrayList<Fruit>();
	private int ash, dol, casp;
	Random random = new Random();
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
		int xc;
		int yc;
		xc = getMiddlePoint();
		yc = getMiddlePoint();
		KocCat cat = new KocCat(xc,yc);
		cat.draw(g, 420, 420);
		
		generatePoison();
		generateFruit();
		generateGhost();
		for(int i=0;i<ash;i++) {
			
		}
		for(int i=0;i<dol;i++) {
			
		}
		for(int i=0;i<casp;i++) {
			
		}
		for(int i=0;i<p;i++) {								//drawing poisons
			pois.get(i).draw(g, W*pois.get(i).getxPos()+W/2,  W*pois.get(i).getyPos()+W/2);
		}
		
		for(int i=0;i<f;i++) {						//drawing fruits
			frui.get(i).draw(g, W*frui.get(i).getxPos()+W/2,  W*frui.get(i).getyPos()+W/2);
		}
	}
		
	//Helper Methods
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
		gho=val;
	}
	public void generatePoison() {
		while(pois.size()<p) {
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
	}
	public void generateFruit() {
		while(frui.size()<f) {
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
					System.out.println(xp + " " + yp + " b");
				}	
			}
			
			Fruit fruit = new Fruit(xp,yp);
			System.out.println("bob");
			frui.add(fruit);
			
		}			
	}
	public void generateGhost() {			//determining the number of each ghost type
		if(gho%3==0) {
			ash=gho/3;
			dol=gho/3;
			casp=gho/3;
		}else if(gho%3==1){
			int m = random.nextInt(3);
			ash=gho/3;
			dol=gho/3;
			casp=gho/3;
			switch(m) {
			case(0):
				ash++;
				break;
			case(1):
				dol++;
				break;
			case(2):
				casp++;
				break;
			}
		}
		else {
			int m = random.nextInt(3);
			ash=gho/3+1;
			dol=gho/3+1;
			casp=gho/3+1;
			switch(m) {
			case(0):
				ash--;
				break;
			case(1):
				dol--;
				break;
			case(2):
				casp--;
				break;
			}
		}
}
	}
