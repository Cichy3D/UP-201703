package pl.expose.up201703.obiekty.model.fizyka;

import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class PojazdSilnikowy extends Pojazd {

	/** Wspó³czynnik tarcia */
	protected double mi = 0.01;
	protected double aktualnaMoc = 0;
	
	public PojazdSilnikowy() {
		super();
	}
	
	public PojazdSilnikowy(Wektor r, Wektor v, Wektor a) {
		super(r, v, a);
	}

	public PojazdSilnikowy(Wektor r, Wektor v, Wektor a, double skret) {
		super(r, v, a, skret);
	}

	public PojazdSilnikowy(Wektor r, Wektor v, Wektor a, double skret, double mi, double aktualnaMoc) {
		super(r, v, a, skret);
		this.mi = mi;
		this.aktualnaMoc = aktualnaMoc;
	}

	@Override
	public void krok(){
		super.krok();
		Wektor p = new Wektor(v);
		p.setR(aktualnaMoc);
		a = a.add(p).minus(  v.mul(mi)  );
	}

	public double getMi() {
		return mi;
	}

	public void setMi(double mi) {
		this.mi = mi;
	}
	
	public double getAktualnaMoc() {
		return aktualnaMoc;
	}

	public void setAktualnaMoc(double aktualnaMoc) {
		this.aktualnaMoc = aktualnaMoc;
	}

	@Override
	public String toString() {
		return    super.toString()
				+ "mi=" + mi + "\n"
				+ "aktualnaMoc=" + aktualnaMoc + "\n";
	} 
}
