package pl.expose.up201703.obiekty;

import pl.expose.up201703.obiekty.model.matematyka.Punkt;

public class Main {

	public static void main(String[] args) {
		Punkt[] tablica = new Punkt[3];
		tablica[0] = new Punkt(11,14);
		tablica[1] = new Punkt(  tablica[0]  );
		tablica[2] = new Punkt(10,56);
		
		//tablica[0].x = 10;
		tablica[0].setX(10);
		//p.x = 10;
		//p.y = 12;
		
		for(Punkt p : tablica){
			System.out.println(p);
		}
		
		System.out.println("Odleg³oœæ punktu 0 od punktu 2 wynosi: "
					+ Punkt.dlugosc(tablica[0], tablica[2]));
	}

}
