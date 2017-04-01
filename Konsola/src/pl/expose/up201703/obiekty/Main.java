package pl.expose.up201703.obiekty;

import java.util.ArrayList;
import java.util.List;

import pl.expose.up201703.obiekty.model.matematyka.Figura;
import pl.expose.up201703.obiekty.model.matematyka.Kolo;
import pl.expose.up201703.obiekty.model.matematyka.Prostokat;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;
import pl.expose.up201703.obiekty.model.matematyka.Trojkat;
import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class Main {

	public static void main(String[] args) {
		
		Punkt pa = new Punkt(0, 10);
		Punkt pb = new Punkt(10, 0);
		Punkt pc = new Wektor();
		
		List<Figura> figury = new ArrayList<>();
		figury.add(new Trojkat(pa, pb, pc));
		figury.add(new Prostokat(pa, pb, 10));
		figury.add(new Kolo(pc, 10));
		
		for(Figura f : figury){
			if(f instanceof Trojkat){
				System.out.println("Dane tr�jk�ta:");
			}
			if(f instanceof Prostokat){
				System.out.println("Dane prostok�ta:");
			}
			if(f instanceof Kolo){
				System.out.println("Dane ko�a:");
			}
			System.out.println("Pole:  "+ f.getPole());
			System.out.println("Obw�d: "+ f.getObwod());
		}
		
		
		
		


	}

}
