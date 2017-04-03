package pl.expose.up201703.obiekty.model.pojemniki;

public interface Pojemnik<T> {

	void dodaj(T o);
	
	void usun(T o);
	
	void wypisz();
	
}
