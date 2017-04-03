package pl.expose.up201703.obiekty;

import java.util.ArrayList;
import java.util.List;

import pl.expose.up201703.obiekty.model.matematyka.Figura;
import pl.expose.up201703.obiekty.model.matematyka.Kolo;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;

public class Main {

	
	
	public static void main(String[] args) {
		
		Figura kolo = new Kolo(new Punkt(), 10);

		
		
		List<Figura> listaFigur = new ArrayList<>();
		listaFigur.add(kolo);
		listaFigur.add(
					new Figura() {
						double a = 10;
						
						public double getPole() {
							return a*a;
						}
						
						public double getObwod() {
							return 4*a;
						}
					}
				);
		
		for (Figura figura : listaFigur) {
			System.out.println("pole = "+figura.getPole());
			System.out.println("obw  = "+figura.getObwod());
		}
		
	}

}
