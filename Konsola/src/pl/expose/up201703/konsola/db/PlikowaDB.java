package pl.expose.up201703.konsola.db;

import pl.expose.up201703.konsola.db.model.User;
import pl.expose.up201703.konsola.db.service.UserDAO;
import pl.expose.up201703.konsola.db.service.UserService;
import pl.expose.up201703.konsola.db.utils.ConsoleUtils;
import pl.expose.up201703.konsola.db.view.MainView;

public class PlikowaDB {

	public static String userName;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Plikowa baza danych u¿ytkowników i dokumentów.");
		UserDAO.loadData();
		
		System.out.print("Witaj u¿ytkowniku, jak siê nazywasz: ");
		userName = ConsoleUtils.readLine();
		User user = UserService.getUser(userName);
		if(user==null){
			user = new User(userName);
			UserDAO.getData().add(user);
			System.out.println("Witaj "+userName+", cieszymy siê, ¿e do nas do³¹czasz!");
		} else {
			System.out.println("Witaj ponownie "+userName+"!");
		}
		
		MainView.mainLoop(user);
		
		ConsoleUtils.close();
		UserDAO.saveData();
	}

}
