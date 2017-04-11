package pl.expose.up201703.konsola.db.view;

import java.util.List;

import pl.expose.up201703.konsola.db.model.Document;
import pl.expose.up201703.konsola.db.model.User;
import pl.expose.up201703.konsola.db.service.DokumentService;
import pl.expose.up201703.konsola.db.service.UserService;
import pl.expose.up201703.konsola.db.utils.ConsoleUtils;

public class DocumentView {

	public static void createDocument(User user){
		System.out.println("Tworzenie dokumentu.");
		String title, content;
		System.out.print("Podaj tytu³: ");
		title = ConsoleUtils.readLine();
		System.out.println("WprowadŸ treœæ dokumentu:");
		System.out.print("> ");
		content = ConsoleUtils.readLine();
		
		Document document = new Document(title, content);
		UserService.addDocument(user, document);
		
		System.out.println("Dokument zosta³ utworzony.");
	}

	public static void listDocuments(User user) {
		System.out.println("Lista dokumentów:");
		List<Document> docs = user.getDocs();
		for(int i=0; i<docs.size(); i++){
			System.out.println((i+1)+": "+docs.get(i));
		}
		if(docs.isEmpty()){
			System.out.println(" --- Brak dokumentów na liœcie ---");
		}
		System.out.println("Wybierz dokument, lub \"0\" aby powróciæ do menu.");
		System.out.print("> ");
		String polecenie = ConsoleUtils.readLine();
		if("0".equals(polecenie)){
			return;
		}
		if(polecenie.matches("\\d+")){
			int nrDokumentu = Integer.parseInt(polecenie) - 1;
			if(nrDokumentu >= docs.size()){
				System.out.println("Nie wybrano poprawnego numeru dokumentu.");
			} else {
				Document document = docs.get(nrDokumentu);
				documentMenu(user, document);
			}
		} else {
			System.out.println("Nie wybrano poprawnego numeru dokumentu.");
		}
	}
	
	public static void documentMenu(User user, Document document){
		String polecenie = null;
		while(!"0".equals(polecenie)){
			System.out.println("-------------------------------------------");
			System.out.println("Wybrano dokument: "+document);
			System.out.println("Wybierz dzia³anie na dokumencie:");
			System.out.println("0. Powrot do menu");
			System.out.println("1. Podgl¹d");
			System.out.println("2. Dopisywanie");
			System.out.println("3. Usuniêcie");
			
			System.out.print("> ");
			polecenie = ConsoleUtils.readLine();
			
			switch (polecenie) {
				case "0": return; 
				case "1": DocumentView.viewDocument(document); break;
				case "2": DocumentView.appendToDocument(document); break;
				case "3": DocumentView.removeDocument(user, document);  return; 
				default: System.out.println("Nie ma takiego polecenia: "+polecenie);
			}
		}
	}

	private static void viewDocument(Document document) {
		System.out.println("Tytu³:           "+document.getTitle());
		System.out.println("Data utworzenia: "+ConsoleUtils.formatDate(document.getDate()));
		System.out.println("Treœæ:\n"+document.getContent());
	}
	
	private static void appendToDocument(Document document) {
		viewDocument(document);
		System.out.print("> ");
		String text = ConsoleUtils.readLine();
		DokumentService.appendToDocument(document, text);
	}
	
	private static void removeDocument(User user, Document document) {
		System.out.println("Usuwam dokument: "+document);
		UserService.removeDocument(user, document);
	}
}
