package pl.expose.up201703.okna.podstawy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	@Override public void paintComponent(Graphics g) {
		int margin = 10;
		Dimension dim = getSize();
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
		g.setColor(Color.green);
		g.fillRect(margin* 2, margin* 2, dim.width - margin * 4, dim.height - margin * 4);
		g.setColor(Color.blue);
		g.fillRect(margin* 3, margin* 3, dim.width - margin * 6, dim.height - margin * 6);
		System.out.println("Rysujê");
	}
	
}
