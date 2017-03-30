package pl.expose.up201703.obiekty;

import pl.expose.up201703.obiekty.model.baza.Osoba;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;

public class Main {

	public static void main(String[] args) {
		
		Osoba a = new Osoba("asdasda", 33, "K", true);
		Osoba b = new Osoba("Basia", 22);
		Osoba c = new Osoba("Adam");
		
		Object[] tablica = new Object[]{a, b, c, null, new Punkt(2, 3)};
		
		
		
		for(Object obiekt : tablica){
			System.out.println(  obiekt  );
		}
	
	}

}
