package pl.expose.up201703.obiekty.model.matematyka;

public class Punkt {

	private double x = 0;
	private double y = 0;
	
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
		return "Punkt p[x,y] = [ " + x + " , " + y + " ]";
	}
	
	public double dlugosc(Punkt bbbb){
		return dlugosc( this , bbbb );
	}
	
	public static double dlugosc(Punkt a, Punkt b){
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	
	
	
}
