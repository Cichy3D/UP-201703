package pl.expose.up201703.obiekty.model.fizyka;

import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class Pojazd extends ObiektFizyczny {

	/** K¹t skrêtu w radianiach */
	protected double skret = 0;
	
	public Pojazd() {
		super();
	}

	public Pojazd(Wektor r, Wektor v, Wektor a) {
		super(r, v, a);
	}

	public Pojazd(Wektor r, Wektor v, Wektor a, double skret) {
		super(r, v, a);
		this.skret = skret;
	}

	@Override
	public void krok(){
		super.krok();
		double kat = v.getKat() + skret;
		v.setKat(kat);
		a.setKat(kat);
	}
	
	/** K¹t skrêtu w radianiach */
	public double getSkret() {
		return skret;
	}

	/** K¹t skrêtu w radianiach */
	public void setSkret(double skret) {
		this.skret = skret;
	}

	@Override
	public String toString() {
		return    super.toString()
				+ "skret=" + skret + "\n";
	} 
	
	
	
}
