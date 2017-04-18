package pl.expose.up201703.kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Iteracje {

	public static void main(String[] args) {
		List<String> lista = Arrays.asList("Ala ma kota, a kot ma Alê. Ala go kocha, a kot j¹ wcale".split(" "));
		Set<String> zbior = new TreeSet<>( (a,b)->b.length()-a.length() );
		Collections.reverse(lista);
		zbior.addAll(lista);

//		for(int i=0; i<lista.size(); i++){
//			System.out.println(lista.get(i));
//		}
		
		for(Iterator<String> i=zbior.iterator(); i.hasNext(); ){
			String s = i.next();
			System.out.println( s );
		}
		
//		for(String s : lista){
//			System.out.println(s);
//		}
		
//		lista.forEach(s -> System.out.println(s));
		
//		lista.stream().forEach(s -> System.out.println(s));
		
//		lista.parallelStream().forEach(s -> System.out.println(s));
		
	}

}
