package pl.expose.up201703.obiekty.model.pojemniki;

import java.util.ArrayList;
import java.util.List;

public class Magazyn<K> implements Pojemnik<K> { 

	private List<K> stanMagazynu = new ArrayList<>();
	
	public void dodaj(K o){
		stanMagazynu.add(o);
	}
	
	public void usun(K o){
		stanMagazynu.remove(o);
	}
	
	public void wypisz(){
		System.out.println("Stan magazynu:");
		for(K o : stanMagazynu){
			System.out.println("    " + o);
		}
	}
	
}
