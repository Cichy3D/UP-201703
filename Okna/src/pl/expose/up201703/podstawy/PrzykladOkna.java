package pl.expose.up201703.podstawy;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PrzykladOkna extends JFrame{
	
	static DrawPanel drawPanel =new DrawPanel();
	
	private static class PanelPrzyklad extends JPanel{
		public PanelPrzyklad(){
			add(new JLabel("Tu jest napis"));
			add(new JButton("Przycisk"));
			JTextField tf = (JTextField) add(new JTextField());
			tf.setColumns(10);
			//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}

	public PrzykladOkna(){
		super("Przyk³ad okna");
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		JPanel panelGlowny = new PanelPrzyklad();
		add(panelGlowny);
		
		panelGlowny.add(drawPanel);
		drawPanel.setPreferredSize(new Dimension(200, 100));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		JFrame okno = new PrzykladOkna();
		
		while(okno.isVisible()){
			Thread.sleep(1000);
			//drawPanel.repaint();
			System.out.println(okno.getSize());
		}
	}

}
