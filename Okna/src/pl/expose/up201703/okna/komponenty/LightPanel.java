package pl.expose.up201703.okna.komponenty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class LightPanel extends JPanel {
	
	private boolean stan = false;

	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Dimension dim = getSize();
		
		GradientPaint gradient;
		if(stan){
			int ile = 64;
			gradient = new GradientPaint(0, 0,                new Color(64+ile,64+ile,64+ile ), 
                    (int)dim.getWidth(), (int)dim.getWidth(), new Color(64+ile,96+ile,128+ile), true);
		} else {
			gradient = new GradientPaint(0, 0,      new Color(64,64,64), 
				    (int)dim.getWidth(), (int)dim.getWidth(), new Color(128,96,64), true);
		}
		g2d.setPaint(gradient);
		
		g2d.fillRoundRect(10, 10, dim.width-10, dim.height-10, 20, 20);
	}

	public boolean isStan() {
		return stan;
	}

	public void setStan(boolean stan) {
		this.stan = stan;
	}
	
	public void changeStan() {
		stan = !stan;
	}
	
}
