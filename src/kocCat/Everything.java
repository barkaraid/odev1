package kocCat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Everything extends JFrame{
	

	public Everything(int f, int p, int gho) {
		Map map = new Map();
		map.setF(f);
		map.setP(p);
		map.setG(gho);
		add(map);
		
		
		Timer timer = new Timer(200,new ActionListener() {
            public void actionPerformed(ActionEvent event) {
           	   map.repaint();
             }
         } );
		  
	timer.start();
	}
}
