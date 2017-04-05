package pl.expose.up201703.obiekty;

import java.util.Comparator;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import pl.expose.up201703.obiekty.model.matematyka.Wektor;

public class Main {

	public static void main(String[] args) {

		Comparator<Wektor> cmpKat =  (a, b) ->  ((Double)a.getKat()).compareTo(b.getKat()) ;
		
		Random random = new Random();
		Set<Wektor> zbior = new TreeSet<>(cmpKat);
		
		for(int i = 0 ; i<10; i++){
			double x = random.nextDouble()*1000;
			double y = random.nextDouble()*1000;
			Wektor w = new Wektor(x, y);
			zbior.add(w);
		}
		
		for (Wektor w : zbior) {
			System.out.printf(Locale.US, "%10.2f, %10.5f\n", w.getR(), w.getKat());
		}
		
		
	}

}
