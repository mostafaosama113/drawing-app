package Main;

import javax.swing.JFrame;

public class DrawingApp extends JFrame{

	public static DrawingApp Main;
	static Panel p;
	
	public static void main(String[] args) {
		Main = new DrawingApp();
	}
	DrawingApp(){
		p = new Panel();
		add(p);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setTitle("Drawing App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}