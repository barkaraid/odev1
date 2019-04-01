package kocCat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class Map extends JPanel {
	public int W = 84;
	public int N = 10;
	private int f;
	private int p;
	private int gho;
	private ArrayList<Poison> pois= new ArrayList<Poison>();
	private ArrayList<Fruit> frui= new ArrayList<Fruit>();
	private ArrayList<Ash> ashh= new ArrayList<Ash>();
	private ArrayList<Dolly> doll= new ArrayList<Dolly>();
	private ArrayList<Casper> casper= new ArrayList<Casper>();
	private int ash, dol, casp;
	Random random = new Random();
	private Timer timer = null;
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
		cat.draw(g, W*N/2, W*N/2);

		generatePoison();
		generateFruit();
		generateGhost();
		generateAsh();
		generateDolly();
		generateCasper();
		
		for(int i=0;i<ash;i++) {					//drawing ashes
			ashh.get(i).draw(g, (int)((W*ashh.get(i).getxPos()))+W/2, (int)(W*ashh.get(i).getyPos())+W/2);
		}
		for(int i=0;i<dol;i++) {					//drawing dollies
			doll.get(i).draw(g, (int)(W*doll.get(i).getxPos())+W/2, (int)(W*doll.get(i).getyPos())+W/2);
		}
		for(int i=0;i<casp;i++) {					//drawing caspers
			casper.get(i).draw(g, (int)(W*casper.get(i).getxPos())+W/2, (int)(W*casper.get(i).getyPos())+W/2);
		}
		for(int i=0;i<p;i++) {								//drawing poisons
			pois.get(i).draw(g, (int)(W*pois.get(i).getxPos())+W/2,  (int)(W*pois.get(i).getyPos())+W/2);
			
		}

		for(int i=0;i<f;i++) {						//drawing fruits
			frui.get(i).draw(g, (int)(W*frui.get(i).getxPos())+W/2,  (int)(W*frui.get(i).getyPos())+W/2);
		}
		
		while(true) {
			
			cat.move(g);
			cat.xPos += cat.xVel/W;
			cat.yPos += cat.yVel/W;
			for(int i=0;i<ash;i++) {
				ashh.get(i).move(g, (int)(W*ashh.get(i).getxPos())+W/2, (int)(W*ashh.get(i).getyPos())+W/2);
				ashh.get(i).xPos+=ashh.get(i).xVel/W;
				ashh.get(i).yPos+=ashh.get(i).yVel/W;
			}
			for(int i=0;i<dol;i++) {
				doll.get(i).move(g,(int)(W*doll.get(i).getxPos())+W/2, (int)(W*doll.get(i).getyPos())+W/2);
				doll.get(i).xPos+=doll.get(i).xVel/W;
				doll.get(i).yPos+=doll.get(i).yVel/W;
			}
			for(int i=0;i<casp;i++) {
				casper.get(i).move(g,(int)(W*casper.get(i).getxPos())+W/2, (int)(W*casper.get(i).getyPos())+W/2);
				casper.get(i).xPos+=casper.get(i).xVel/W;
				casper.get(i).yPos+=casper.get(i).yVel/W;
			}
			for(int i=0;i<p;i++) {								//drawing poisons
				pois.get(i).grow(g,(int)(W*pois.get(i).getxPos())+W/2,  (int)(W*pois.get(i).getyPos())+W/2);
			}
			for(int i=0;i<f;i++) {						//drawing fruits
				frui.get(i).grow(g,(int)(W*frui.get(i).getxPos())+W/2, (int)( W*frui.get(i).getyPos())+W/2);
			}

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
			int xp = random.nextInt(N);			//x position that determines the box in which the object is generated	
			int yp = random.nextInt(N);			//y position that determines the box in which the object is generated
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
	public void generateAsh() {
		while(ashh.size()<ash) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			System.out.println(xp +" a " + yp);

			for(Ash temp: ashh) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					System.out.println(xp + " " + yp +" a");
				}
			}
			Ash ash = new Ash(xp,yp);
			ashh.add(ash);
		}
	}
	public void generateDolly() {
		while(doll.size()<dol) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			System.out.println(xp +" a " + yp);

			for(Dolly temp: doll) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					System.out.println(xp + " " + yp +" a");
				}
			}
			Dolly dolly = new Dolly(xp,yp);
			doll.add(dolly);
		}
	}
	public void generateCasper() {
		while(casper.size()<casp) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			System.out.println(xp +" a " + yp);

			for(Casper temp: casper) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					System.out.println(xp + " " + yp +" a");
				}
			}
			Casper cas = new Casper(xp,yp);
			casper.add(cas);
		}
	}
	/*public void actionPerformed(ActionEvent e, Graphics g, KocCat cat) {
		cat.move(g);
		cat.xPos += cat.xVel/W;
		cat.yPos += cat.yVel/W;
		for(int i=0;i<ash;i++) {
			ashh.get(i).move(g, (int)(W*ashh.get(i).getxPos())+W/2, (int)(W*ashh.get(i).getyPos())+W/2);
			ashh.get(i).xPos+=ashh.get(i).xVel/W;
			ashh.get(i).yPos+=ashh.get(i).yVel/W;
		}
		for(int i=0;i<dol;i++) {
			doll.get(i).move(g,(int)(W*doll.get(i).getxPos())+W/2, (int)(W*doll.get(i).getyPos())+W/2);
			doll.get(i).xPos+=doll.get(i).xVel/W;
			doll.get(i).yPos+=doll.get(i).yVel/W;
		}
		for(int i=0;i<casp;i++) {
			casper.get(i).move(g,(int)(W*casper.get(i).getxPos())+W/2, (int)(W*casper.get(i).getyPos())+W/2);
			casper.get(i).xPos+=casper.get(i).xVel/W;
			casper.get(i).yPos+=casper.get(i).yVel/W;
		}
		for(int i=0;i<p;i++) {								//drawing poisons
			pois.get(i).grow(g,(int)(W*pois.get(i).getxPos())+W/2,  (int)(W*pois.get(i).getyPos())+W/2);
		}
		for(int i=0;i<f;i++) {						//drawing fruits
			frui.get(i).grow(g,(int)(W*frui.get(i).getxPos())+W/2, (int)( W*frui.get(i).getyPos())+W/2);
		}
	}*/

	
}
