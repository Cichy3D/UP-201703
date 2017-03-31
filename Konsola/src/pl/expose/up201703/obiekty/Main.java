package pl.expose.up201703.obiekty;

import java.util.ArrayList;
import java.util.List;

import pl.expose.up201703.obiekty.model.matematyka.Figura;
import pl.expose.up201703.obiekty.model.matematyka.Kolo;
import pl.expose.up201703.obiekty.model.matematyka.Prostokat;
import pl.expose.up201703.obiekty.model.matematyka.Punkt;
import pl.expose.up201703.obiekty.model.matematyka.Trojkat;

public class Main {

	public static void main(String[] args) {
		
		Punkt pa = new Punkt(0, 10);
		Punkt pb = new Punkt(10, 0);
		Punkt pc = new Punkt(0, 0);
		
		List<Figura> figury = new ArrayList<>();
		figury.add(new Trojkat(pa, pb, pc));
		figury.add(new Prostokat(pa, pb, 10));
		figury.add(new Kolo(pc, 10));
		
		for(Figura f : figury){
			if(f instanceof Trojkat){
				System.out.println("Dane trójk¹ta:");
			}
			if(f instanceof Prostokat){
				System.out.println("Dane prostok¹ta:");
			}
			if(f instanceof Kolo){
				System.out.println("Dane ko³a:");
			}
			System.out.println("Pole:  "+ f.getPole());
			System.out.println("Obwód: "+ f.getObwod());
		}
		
		
		
		


	}

}
