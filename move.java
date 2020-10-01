package cars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class move extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int space;
	private int speed;
	private int width = 80;
	private int height = 70;
	private int WIDTH = 500;
	private int HEIGHT = 700;
	private ArrayList <Rectangle> ocars;
	private Random rand;
	private Rectangle car;
	Timer t;
	
	
	public move () {
		t = new Timer(20,this);
		rand = new Random();
		ocars = new ArrayList<Rectangle>();
		car = new Rectangle(WIDTH/2 -90,HEIGHT-100,width,height);
		space = 100;
		speed = 2;
		addocars(true) ;
		addocars(true) ;
		addocars(true) ;
		addocars(true);
		t.start();
		 
	}
	public void addocars(boolean first) {
		int positionx = rand.nextInt() % 2;
		int x = 0;
		int y = 0;
		int Width = width;
		int Height = height;
		if (positionx == 0) {
			x = WIDTH/2 - 90 ;
		}else {
			x = WIDTH/2 + 10 ;
		}
		if (first) {
			ocars.add(new Rectangle(x,y-100-(ocars.size()*space),Width,Height));
		}else {
			ocars.add(new Rectangle(x,ocars.get(ocars.size()-1).y-300,Width,Height));
		}
		 
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.green);
		g.fillRect(WIDTH/2-100, 0, 200, HEIGHT);
		g.setColor(Color.red);
		g.fillRect(car.x, car.y, car.width, car.height);
		g.setColor(Color.yellow);
		g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
		g.setColor(Color.blue);
		for(Rectangle rect: ocars) {
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		Rectangle rect;
		for (int i = 0 ; i < ocars.size(); i ++) {
			rect = ocars.get(i);
			rect.y += speed;
		}
		repaint();
		for (Rectangle r : ocars) {
			if (r.intersects(car)) {
				car.y = r.y + height;
			}
		}
		for (int i = 0 ;i<ocars.size();i++ ) {
			rect = ocars.get(i);
			if (rect.y+rect.height>HEIGHT) {
				ocars.remove(rect);
				addocars(false);
			}
		}
		
		repaint();
	}
	
	
	

}
