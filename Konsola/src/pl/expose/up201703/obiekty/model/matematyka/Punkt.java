package pl.expose.up201703.obiekty.model.matematyka;

import java.util.Locale;

public class Punkt {

	protected double x = 0;
	protected double y = 0;
	
	public Punkt(){
	}
	
	public Punkt(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Punkt(Punkt inny){
		this.x = inny.x;
		this.y = inny.y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString(){
		
		return String.format(Locale.US, "Punkt p[x,y] = [ %.2f , %.2f ]", x, y);
	}
	
	public double dlugosc(Punkt inny){
		return dlugosc( this , inny );
	}
	
	public static double dlugosc(Punkt a, Punkt b){
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	
	
	
}
