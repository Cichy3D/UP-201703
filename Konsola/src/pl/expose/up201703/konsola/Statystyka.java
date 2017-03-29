package pl.expose.up201703.konsola;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Statystyka {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Podaj iloœæ liczb.");
		Scanner scanner = new Scanner(System.in);
		
		Locale myLocale = new Locale(System.getProperty("user.language") , System.getProperty("user.country"));

		int n = scanner.nextInt();
		
		double[] tablica = new double[n];
		
		System.out.println("Podaj ci¹g o d³ugoœci "+n+" liczb.");
		
		for(int i=0; i<tablica.length; i++){
			tablica[i] = scanner.nextDouble();
		}
		System.out.println("Liczby wpisano.");
		
		
		int ileWpisow = 0;
		double suma = 0;
		int sumaZnakow = 0;
		
		for(double liczba : tablica){

			ileWpisow++;
			suma += liczba;
			sumaZnakow += (""+liczba).length();
			
		}
		
		NumberFormat nf = NumberFormat.getNumberInstance(myLocale);
		double srednia = ((double)suma)/ileWpisow;
		
		
		
		System.out.println("Wposów:      " + nf.format(ileWpisow) );
		System.out.println("Suma:        " + nf.format(suma)      );
		System.out.println("Œrednia:     " + nf.format(srednia)   );
		System.out.println("Suma znaków: " + nf.format(sumaZnakow));
		
		scanner.close();
	}

}
