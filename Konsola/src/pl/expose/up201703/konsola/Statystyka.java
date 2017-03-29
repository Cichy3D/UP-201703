package pl.expose.up201703.konsola;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Statystyka {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Podaj ci�g liczb.");
		
		int ileWpisow = 0;
		int suma = 0;
		int sumaZnakow = 0;
		
		//System.out.println( new File(".").getAbsolutePath() );
		
		Scanner scanner = new Scanner(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("liczby.txt"));
		String odpowiedzUzytkownika;
		
		do{
			odpowiedzUzytkownika = scanner.nextLine();
			if(  odpowiedzUzytkownika.matches("\\d+")  ){
				int odpInt = Integer.parseInt(odpowiedzUzytkownika);
				ileWpisow++;
				suma += odpInt;
				sumaZnakow += odpowiedzUzytkownika.length();
			} else {
				System.out.println("Wpis nie pasuje do wzorca");
			}
		}while(!odpowiedzUzytkownika.equals("."));
		
		System.out.println("Wpos�w: "+ileWpisow);
		System.out.println("Suma: "+suma);
		System.out.println("�rednia: "+((double)suma)/ileWpisow);
		System.out.println("Suma znak�w: "+sumaZnakow);
		
		scanner.close();
	}

}
