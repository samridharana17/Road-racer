package cars;

import javax.swing.JFrame;



public class Cars extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		   JFrame app = new JFrame(); 
		   move m = new move();
		   app.add(m);
		   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   app.setSize(500,750);
		   app.setVisible(true);
		   
	}

}