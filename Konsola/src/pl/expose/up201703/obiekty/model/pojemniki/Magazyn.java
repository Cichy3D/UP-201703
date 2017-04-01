package pl.expose.up201703.obiekty.model.pojemniki;

import java.util.ArrayList;
import java.util.List;

public class Magazyn implements Pojemnik { 

	private List<Object> stanMagazynu = new ArrayList<>();
	
	public void dodaj(Object o){
		stanMagazynu.add(o);
	}
	
	public void usun(Object o){
		stanMagazynu.remove(o);
	}
	
	public void wypisz(){
		System.out.println("Stan magazynu:");
		for(Object o : stanMagazynu){
			System.out.println("    " + o);
		}
	}
	
}
