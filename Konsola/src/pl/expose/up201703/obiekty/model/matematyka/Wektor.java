package pl.expose.up201703.obiekty.model.matematyka;

public class Wektor extends Punkt {

	public Wektor() {
		super();
	}

	public Wektor(double x, double y) {
		super(x, y);
	}

	public Wektor(Wektor inny) {
		super(inny);
	}
	
	public Wektor(Punkt a, Punkt b) {
		super(  b.x-a.x  , b.y-a.y  );
	}
	
	public double getR(){
		Punkt punkt = new Punkt(0,0);
		return dlugosc(punkt);
	}
	
	public void setR(double r){
		double kat = getKat();
		x = r * Math.cos(kat);
		y = r * Math.sin(kat);
	}
	
	public double getKat(){
		return Math.atan2(y, x);
	}
	
	public void setKat(double kat){
		double r = getR();
		x = r * Math.cos(kat);
		y = r * Math.sin(kat);
	}
	
	public Wektor add(Wektor inny){
		return new Wektor( this.x+inny.x,  this.y+inny.y );
	}
	
	public Punkt add(Punkt punkt){
		return new Punkt( this.x+punkt.x,  this.y+punkt.y );
	}
	
	public Wektor reverse(){
		return new Wektor( -this.x,  -this.y );
	}
	
	public Wektor minus(Wektor inny){
		return add(   inny.reverse()   );
	}
	
	public double mul(Wektor inny){
		return Math.abs(  x * inny.y  -  inny.x * y );
	}
	
	public Wektor mul(double liczba){
		return new Wektor( this.x*liczba,  this.y*liczba );
	}
}
