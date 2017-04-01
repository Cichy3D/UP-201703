package pl.expose.up201703.obiekty;

import pl.expose.up201703.obiekty.model.baza.Osoba;
import pl.expose.up201703.obiekty.model.matematyka.Prostokat;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;
import pl.expose.up201703.obiekty.model.pojemniki.Magazyn;
import pl.expose.up201703.obiekty.model.pojemniki.Niszczarka;
import pl.expose.up201703.obiekty.model.pojemniki.Pojemnik;

public class Main {

	public static void main(String[] args) {
		
		Pojemnik pojemnik = new Niszczarka();
		
		pojemnik.dodaj("Samochód");
		pojemnik.dodaj("Nietoperz");
		pojemnik.dodaj("Ala");
		pojemnik.dodaj("Ala");
		pojemnik.dodaj(new Osoba("Marek", 31));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(), 10));
		
		pojemnik.usun("Ala");
		
		pojemnik.wypisz();
		
	}

}
