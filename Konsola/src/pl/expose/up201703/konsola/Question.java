package pl.expose.up201703.konsola;

import java.util.Scanner;

public class Question {

	public static void main(String[] args) {
		System.out.println("Hej tam!");
		System.out.println("Jak si� nazywasz? ");
		
		System.out.print("> ");
		Scanner scanner = new Scanner(System.in);
		String imie = scanner.nextLine();
		System.out.println("Witaj "+imie+", ile masz lat?");
		System.out.print("> ");
		String wiekString = scanner.nextLine();
		double wiek = Double.parseDouble(wiekString);
		
		if(wiek<18){
			System.out.println("Sorki "+imie+", nie mo�esz jeszcze pi�, poczekaj "+(18-wiek)+" lat");
		} else {
			System.out.println("OK "+imie+", to co? Idziemy pi�?");
			
			System.out.print("T/N > ");
			String odp = scanner.nextLine();
			
			if(odp.equals("N")){
				System.out.println("Straszny z ciebie burak!");
			} else {
				System.out.println("Straszny z Ciebie pijak. Nie wypada tak w wieku "+wiek+" lat.");
			}
			
		}
		
		scanner.close();
		System.out.println("END.");
	}

}
