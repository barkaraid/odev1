package kocCat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class Map extends JPanel implements KeyListener, ActionListener{
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
	int xc = W*N/2;
	int yc = W*N/2;
	String str = "left";
	int constant = 10;
	
	KocCat cat = new KocCat((xc-W/2)/W,(yc-W/2)/W);
	public Map() {
		
		
	}
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
		
		
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		cat.draw(g, (W*cat.xPos)+W, (W*cat.yPos)+W,W,N);
		cat.setxPos(cat.getxPos()+(cat.xVel)/W);
		cat.setyPos(cat.getyPos()+cat.yVel/W);
		generatePoison();
		generateFruit();
		generateGhost();
		generateAsh();
		generateDolly();
		generateCasper();
		

		for(int i=0;i<ash;i++) {					//drawing ashes
			ashh.get(i).draw(g, ((W*ashh.get(i).getxPos()))+W/2, (W*ashh.get(i).getyPos())+W/2,W,N);
			ashh.get(i).setxPos(ashh.get(i).getxPos()+(ashh.get(i).xVel)/W);
		}
		for(int i=0;i<dol;i++) {					//drawing dollies
			doll.get(i).draw(g, (W*doll.get(i).getxPos())+W/2, (W*doll.get(i).getyPos())+W/2,W,N);
			doll.get(i).setyPos(doll.get(i).getyPos()+(doll.get(i).yVel)/W);
		}
		for(int i=0;i<casp;i++) {					//drawing caspers
			casper.get(i).draw(g, (W*casper.get(i).getxPos())+W/2, (W*casper.get(i).getyPos())+W/2,W,N);
			casper.get(i).setxPos(casper.get(i).getxPos()+(casper.get(i).xVel)/W);
			casper.get(i).setyPos(casper.get(i).getyPos()+(casper.get(i).yVel)/W);
		}
		for(int i=0;i<p;i++) {								//drawing poisons
			pois.get(i).draw(g,(int)(W*pois.get(i).getxPos())+W/2, (int)(W*pois.get(i).getyPos())+W/2);
			
		}
		for(int i=0;i<f;i++) {						//drawing fruits
			frui.get(i).draw(g, (int)(W*frui.get(i).getxPos())+W/2,  (int)(W*frui.get(i).getyPos())+W/2,N);
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
			

			for(Poison temp: pois) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
				}
			}
			for(Fruit temp: frui) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);

				}


			}
			Poison poison = new Poison(xp,yp);
			pois.add(poison);

		}
	}
	public void generateFruit() {
		while(frui.size()<f) {
			int xp = random.nextInt(N);			//x position that determines the box in which the object is generated	
			int yp = random.nextInt(N);			//y position that determines the box in which the object is generated

			for(Poison temp: pois) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
				}
			}
			for(Fruit temp: frui) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
				
				}	
			}

			Fruit fruit = new Fruit(xp,yp);
			
			frui.add(fruit);

		}			
	}
	public void generateGhost() {			//determining the number of each ghost type
		
		if(gho%3==0) {
			ash=gho/3;
			
			dol=gho/3;
			
			casp=gho/3;
			
		}else if(gho%3==1){
			
			ash=gho/3+1;
			
			dol=gho/3;
			
			casp=gho/3;
			
			
		}
		else {
			
			ash=gho/3+1;
			dol=gho/3+1;
			casp=gho/3;
			
		}
	}
	public void generateAsh() {
		while(ashh.size()<ash) {
			int xp = random.nextInt(N);
			int yp = random.nextInt(N);
			

			for(Ash temp: ashh) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
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
			

			for(Dolly temp: doll) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
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
			

			for(Casper temp: casper) {
				if(xp == temp.getxPos() && yp == temp.getyPos()) {
					xp = random.nextInt(N);
					yp = random.nextInt(N);
					
				}
			}
			Casper cas = new Casper(xp,yp);
			casper.add(cas);
		}
	}

	public void up() {
		cat.str="up";
		cat.yVel-=cat.cons;
	}
	public void down() {
		cat.str="down";
		cat.yVel+=cat.cons;
	}
	public void left() {
		cat.str="left";
		cat.xVel-=cat.cons;
	}
	public void right() {
		cat.str="right";
		cat.xVel+= cat.cons;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_DOWN) {
			down();
		}
		if(code == KeyEvent.VK_UP) {
			up();
		}
		if(code == KeyEvent.VK_RIGHT) {
			right();
		}
		if(code == KeyEvent.VK_LEFT) {
			left();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		cat.cons = 10;
		
	}

	
}
