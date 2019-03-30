package kocCat;
import java.awt.*;
import javax.swing.*;

public class Map extends JPanel{
	public int W = 84;
	public int N = 10;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		int x = 0;
		int y = 0;
		
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g.drawRect(x, y, W, W);
				x+=W;
			}
			x=0;
			y+=W;
		}
	}
	public int getMiddlePoint() {
		return (W*N)/2;
	}
}
