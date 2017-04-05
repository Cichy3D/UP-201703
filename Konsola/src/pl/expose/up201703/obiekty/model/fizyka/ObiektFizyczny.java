package pl.expose.up201703.obiekty.model.fizyka;

import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public abstract class ObiektFizyczny {

	protected Wektor r = new Wektor();
	protected Wektor v = new Wektor();
	protected Wektor a = new Wektor();
	
	public ObiektFizyczny() {}

	public ObiektFizyczny(Wektor r, Wektor v, Wektor a) {
		this.r = r;
		this.v = v;
		this.a = a;
	}

	public void krok(){
		r = r.add(v);
		v = v.add(a);
	}
	
	public Wektor getR() {
		return r;
	}
	public void setR(Wektor r) {
		this.r = r;
	}
	public Wektor getV() {
		return v;
	}
	public void setV(Wektor v) {
		this.v = v;
	}
	public Wektor getA() {
		return a;
	}
	public void setA(Wektor a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return    "r=" + r + "\n"
				+ "v=" + v + "\n"
				+ "a=" + a + "\n";
	}
	
	
	
}
