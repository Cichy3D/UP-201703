package pl.expose.up201703.okna.rysowanie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class DomekPanel extends JPanel {
	
	private long step = 0;
	private static final long MAX_STEP = 120;
	
	public void animate(){
		
		step = (System.currentTimeMillis()/10) % MAX_STEP;
		repaint();
	}

	@Override public void paintComponent(Graphics og) {
		Graphics2D g = (Graphics2D) og;
		
		//LocalTime t = LocalTime.now();
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getWidth());
		
		g.setColor(Color.white);
		g.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		GradientPaint gradient = new GradientPaint(0, 0, Color.RED, 0, 50, Color.GREEN, true);
		g.setPaint(gradient);
		
		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		path.moveTo(100, 100);
		//path.lineTo(200, 100);
		path.curveTo(50, 180, 250, step, 200-step, 100);
		path.closePath();
		g.fill(path);
		g.setColor(Color.white);
		g.draw(path);
		
//		Wektor a = new Wektor();
//		Wektor b = new Wektor(100,100);
//		linia(g, a, b);
//		a = new Wektor(b);
//		b.setKat(Math.PI/6);
//		b = b.add(b);
//		
//		linia(g, a, b);
	}
	
	private void linia(Graphics2D g, Wektor a, Wektor b){
		g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
	}
	
}
