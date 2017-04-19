package pl.expose.up201703.kolekcje;

import static java.lang.System.out;

import java.util.*;

import pl.expose.up201703.obiekty.model.baza.Osoba;
import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class IteracjeMapy {

	public static void main(String[] args) {
		Map<String, Object> mapa = new HashMap<>();
		
		mapa.put("Osoba", new Osoba("Ala"));
		mapa.put("Wektor A", new Wektor(10, 20));
		mapa.put("Wektor B", new Wektor(20, 11));
		mapa.put("Osoba B", new Osoba("Ela"));
		mapa.put("Wektor C", mapa.get("Wektor B"));
		
		//System.out.println(    mapa.get("Osoba")    );

//		for(String key : mapa.keySet()){
//			Object value = mapa.get(key);
//			System.out.println(key + "\t\t" + value);
//		}
		
//		for(Object value : mapa.values()){
//			System.out.println( value);
//		}
		
//		for(Map.Entry<String, Object> entry : mapa.entrySet()){
//			System.out.println(entry.getKey() + "\t\t" + entry.getValue());
//		}
		
//		mapa.entrySet().forEach(e->
//				System.out.println(e.getKey() + "\t\t" + e.getValue())
//			);

		mapa.forEach((k,v)->out.println(k + "\t\t" + v));
		
		
	}

}
