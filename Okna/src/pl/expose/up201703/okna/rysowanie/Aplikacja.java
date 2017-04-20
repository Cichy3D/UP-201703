package pl.expose.up201703.okna.rysowanie;

import javax.swing.JFrame;

public class Aplikacja extends JFrame {

	static DomekPanel panel = new DomekPanel();
	
	public Aplikacja(){
		super("Aplikacja rysuj¹ca");
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame okno = new Aplikacja();
		
		while(okno.isVisible()){
			Thread.sleep(50);
			panel.animate();
		}
		
	}

}
