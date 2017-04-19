package pl.expose.up201703.kolekcje;

import static java.lang.System.out;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import pl.expose.up201703.obiekty.model.baza.Osoba;

public class Indeksy {

	public static void main(String[] args) throws Exception {
		File plik = new File("src/pl/expose/up201703/kolekcje/osoby.csv");
		Scanner scanner = new Scanner(plik);
		Set<Osoba> osobySet = new HashSet<>();
		while(scanner.hasNextLine()){
			Osoba o = Osoba.buildOsoba(scanner.nextLine());
			osobySet.add(o);
		}
		scanner.close();
		
		Map<Long, Osoba> osobaIdMap = osobySet.stream()
				.collect(Collectors
						.toMap(o->((Osoba)o).getId(), o->o));
		
		Map<String, List<Osoba>> osobaNazwaMap = new HashMap<>();
		for(Osoba o : osobySet){
			String nazwa = o.getNazwa();
			List<Osoba> lista = osobaNazwaMap.getOrDefault(nazwa, new ArrayList<>());
			lista.add(o);
			osobaNazwaMap.put(nazwa, lista);
		}
		
		osobaNazwaMap.forEach((k,v)->out.println(k + ": " + v));
		
	}

}
