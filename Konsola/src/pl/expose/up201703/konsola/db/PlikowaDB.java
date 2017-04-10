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
		System.out.println("Plikowa baza danych u�ytkownik�w i dokument�w.");
		UserDAO.loadData();
		
		System.out.print("Witaj u�ytkowniku, jak si� nazywasz: ");
		Scanner scanner = new Scanner(System.in);
		userName = scanner.nextLine();
		User user = UserService.getUser(userName);
		if(user==null){
			user = new User(userName);
			UserDAO.getData().add(user);
			System.out.println("Witaj "+userName+", cieszymy si�, �e do nas do��czasz!");
		} else {
			System.out.println("Witaj ponownie "+userName+"!");
		}
		
		String polecenie = null;
		while(!"0".equals(polecenie)){
			System.out.println("-------------------------------------------");
			System.out.println("Wybierz dzia�anie:");
			System.out.println("0. Zako�cz program");
			System.out.println("1. Utw�rz nowy dokument");
			System.out.println("2. Lista dokument�w");
			if(user.isAdmin()){
				System.out.println("3. Lista u�ytkownik�w");
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
