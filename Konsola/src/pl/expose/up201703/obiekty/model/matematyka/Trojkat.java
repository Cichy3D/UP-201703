package pl.expose.up201703.obiekty.model.matematyka;

public class Trojkat extends Figura {

	private Punkt punktA;
	private Punkt punktB;
	private Punkt punktC;
	
	public Trojkat() {
		punktA = new Punkt();
		punktB = new Punkt(); 
		punktC = new Punkt();
	}

	public Trojkat(Punkt punktA, Punkt punktB, Punkt punktC) {
		super();
		this.punktA = punktA;
		this.punktB = punktB;
		this.punktC = punktC;
	}
	
	public double getObwod() {
		double d1 = punktA.dlugosc(punktB);
		double d2 = punktB.dlugosc(punktC);
		double d3 = punktA.dlugosc(punktC);
		return d1 + d2 + d3;
	}
	
	public double getPole(){
		Wektor w1 = new Wektor(punktA, punktB);
		Wektor w2 = new Wektor(punktA, punktC);
		
		return 0.5 * w1.mul(w2);
	}
	

	public Punkt getPunktA() {
		return punktA;
	}

	public void setPunktA(Punkt punktA) {
		this.punktA = punktA;
	}

	public Punkt getPunktB() {
		return punktB;
	}

	public void setPunktB(Punkt punktB) {
		this.punktB = punktB;
	}

	public Punkt getPunktC() {
		return punktC;
	}

	public void setPunktC(Punkt punktC) {
		this.punktC = punktC;
	}
	
}
