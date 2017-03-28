package pl.expose.up201703.konsola;

import java.util.Scanner;

public class Question {

	public static void main(String[] args) {
		System.out.println("Hej tam!");
		System.out.println("Jak siê nazywasz? ");
		
		System.out.print("> ");
		Scanner scanner = new Scanner(System.in);
		String imie = scanner.nextLine();
		System.out.println("Witaj "+imie+", ile masz lat?");
		System.out.print("> ");
		String wiekString = scanner.nextLine();
		double wiek = Double.parseDouble(wiekString);
		
		if(wiek<18){
			System.out.println("Sorki "+imie+", nie mo¿esz jeszcze piæ, poczekaj "+(18-wiek)+" lat");
		} else {
			String odpowiedz;
			
			odpowiedz = pytanie(scanner, imie);
			
			while(odpowiedz.equals("N")){
				System.out.println("Straszny z ciebie burak!");
				
				odpowiedz = pytanie(scanner, imie);
			}
			
			System.out.println("Straszny z Ciebie pijak. Nie wypada tak w wieku "+wiek+" lat.");
			
			
		}
		
		scanner.close();
		System.out.println("END.");
	}

	private static String pytanie(Scanner scanner, String imie) {
		String odp;
		System.out.println("OK "+imie+", to co? Idziemy piæ?");
		System.out.print("T/N > ");
		odp = scanner.nextLine();
		return odp;
	}

}
