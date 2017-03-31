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
		return punktA.dlugosc(punktB) + punktB.dlugosc(punktC) + punktA.dlugosc(punktC);
	}
	
	public double getPole(){
		return 0.5 * Math.abs(  
				+ punktA.getX() * punktB.getY() 
				+ punktB.getX() * punktC.getY() 
				+ punktC.getX() * punktA.getY() 
				- punktC.getX() * punktB.getY() 
				- punktA.getX() * punktC.getY() 
				- punktB.getX() * punktA.getY() 
			);
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
