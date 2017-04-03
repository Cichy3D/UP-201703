package pl.expose.up201703.obiekty;

import pl.expose.up201703.obiekty.model.baza.Osoba;
import pl.expose.up201703.obiekty.model.matematyka.Figura;
import pl.expose.up201703.obiekty.model.matematyka.Prostokat;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;
import pl.expose.up201703.obiekty.model.pojemniki.Magazyn;
import pl.expose.up201703.obiekty.model.pojemniki.Niszczarka;
import pl.expose.up201703.obiekty.model.pojemniki.Pojemnik;
import pl.expose.up201703.obiekty.model.pojemniki.Szafa;
import pl.expose.up201703.obiekty.model.pojemniki.Szufladka;

public class Main {

	public static void main(String[] args) {
		
		Pojemnik<Figura> pojemnik = new Magazyn<>();
		
//		pojemnik.dodaj("Samochód");
//		pojemnik.dodaj("Nietoperz");
//		pojemnik.dodaj("Ala");
//		pojemnik.usun("Samochód");
//
//		pojemnik.dodaj(new Osoba("Marek", 31));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(0,10), 10));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(), 20));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(), 30));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(), 40));
		pojemnik.dodaj(new Prostokat(new Punkt(10,0), new Punkt(), 50));
		
//		pojemnik.usun("Ala");
//		pojemnik.usun("Nieznany fragment tekstu");
		
		pojemnik.wypisz();
		
	}

}
