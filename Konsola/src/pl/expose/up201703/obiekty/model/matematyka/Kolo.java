package pl.expose.up201703.obiekty.model.matematyka;

public class Kolo extends Figura {

	private Punkt srodek;
	private double r;
	
	public Kolo() {
		srodek = new Punkt();
		r = 0;
	}

	public Kolo(Punkt srodek, double r) {
		this.srodek = srodek;
		this.r = r;
	}
	
	public Kolo(Punkt srodek, Punkt t) {
		this.srodek = srodek;
		this.r = srodek.dlugosc(t);
	}
	
	public double getPole() {
		return r*r*Math.PI;
	}
	
	public double getObwod() {
		return 2*r*Math.PI;
	}
	
	public boolean czyWKole(Punkt g){
		return r > srodek.dlugosc(g);
	}

	public boolean czyNaKole(Punkt g){
		return Math.abs(r - srodek.dlugosc(g)) < 0.000000001;
	}
	
	public Punkt getSrodek() {
		return srodek;
	}

	public void setSrodek(Punkt srodek) {
		this.srodek = srodek;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	
	
	
}
