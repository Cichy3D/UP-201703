package pl.expose.up201703.konsola.db.view;

import pl.expose.up201703.konsola.db.model.User;
import pl.expose.up201703.konsola.db.service.DokumentService;
import pl.expose.up201703.konsola.db.service.UserService;
import pl.expose.up201703.konsola.db.utils.ConsoleUtils;

public class MainView {

	public static void mainLoop(User user) {
		
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
			polecenie = ConsoleUtils.readLine();
			
			switch (polecenie) {
				case "0": System.out.println("Do zobaczenia."); break;
				case "1": DocumentView.createDocument(user); break;
				case "2": DocumentView.listDocuments(user); break;
				case "3": if(user.isAdmin()){   UserView.listUsers();   break; }
				default: System.out.println("Nie ma takiego polecenia: "+polecenie);
			}
		}
		
	}

	
	
}
