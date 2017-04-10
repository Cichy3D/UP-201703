package pl.expose.up201703.konsola.db;

import java.io.File;
import java.util.Scanner;

import pl.expose.up201703.konsola.db.model.User;
import pl.expose.up201703.konsola.db.service.DokumentService;
import pl.expose.up201703.konsola.db.service.UserDAO;
import pl.expose.up201703.konsola.db.service.UserService;

public class PlikowaDB {

	public static String userName;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Plikowa baza danych u¿ytkowników i dokumentów.");
		UserDAO.loadData();
		
		System.out.print("Witaj u¿ytkowniku, jak siê nazywasz: ");
		Scanner scanner = new Scanner(System.in);
		userName = scanner.nextLine();
		User user = UserService.getUser(userName);
		if(user==null){
			user = new User(userName);
			UserDAO.getData().add(user);
			System.out.println("Witaj "+userName+", cieszymy siê, ¿e do nas do³¹czasz!");
		} else {
			System.out.println("Witaj ponownie "+userName+"!");
		}
		
		String polecenie = null;
		while(!"0".equals(polecenie)){
			System.out.println("-------------------------------------------");
			System.out.println("Wybierz dzia³anie:");
			System.out.println("0. Zakoñcz program");
			System.out.println("1. Utwórz nowy dokument");
			System.out.println("2. Lista dokumentów");
			if(user.isAdmin()){
				System.out.println("3. Lista u¿ytkowników");
			}
			System.out.print("> ");
			polecenie = scanner.nextLine();
		
			switch (polecenie) {
				case "0": System.out.println("Do zobaczenia."); break;
				case "1": DokumentService.createDocument(user); break;
				case "2": DokumentService.listDocuments(user); break;
				case "3": if(user.isAdmin()){   UserService.listUsers();   break; }
				default: System.out.println("Nie ma takiego polecenia: "+polecenie);
			}
		}
		
		scanner.close();
		UserDAO.saveData();
	}

}
