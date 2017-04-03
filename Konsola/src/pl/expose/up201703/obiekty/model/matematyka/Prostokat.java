package pl.expose.up201703.obiekty.model.matematyka;

public class Prostokat extends Figura{
	
	private Punkt punktA;
	private Punkt punktB;
	private double d;
	
	public Prostokat() {
		punktA = new Punkt();
		punktB = new Punkt();
		d=0;
	}

	public Prostokat(Punkt punktA, Punkt punktB, double d) {
		super();
		this.punktA = punktA;
		this.punktB = punktB;
		this.d = d;
	}
	
	public double getPole() {
		return punktA.dlugosc(punktB) * d;
	}
	
	public double getObwod() {
		double d1 = punktA.dlugosc(punktB);
		return 2*d1 + 2*d;
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

	public double getD() {
		return d;
	}
	
	public Punkt getPunktC() {
		Wektor w = new Wektor(punktA, punktB);
		w.setKat(  w.getKat() - Math.PI/2   );
		w.setR(d);
		return w.add(punktB);
	}
	
	public Punkt getPunktD() {
		Wektor w = new Wektor(punktA, punktB);
		w.setKat(  w.getKat() - Math.PI/2   );
		w.setR(d);
		return w.add(punktA);
	}

	public void setD(double d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "Prostokat [A=" + getPunktA() + ", B=" + getPunktB() + ", C=" + getPunktC()
				+ ", D=" + getPunktD() + "]";
	}

    
}
