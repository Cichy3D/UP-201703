package pl.expose.up201703.konsola.db.view;

import java.util.List;

import pl.expose.up201703.konsola.db.model.User;
import pl.expose.up201703.konsola.db.service.UserDAO;
import pl.expose.up201703.konsola.db.utils.ConsoleUtils;

public class UserView {
	
	public static void listUsers() {
		System.out.println(" ------------------------------------- ");
		System.out.println("Operacje na u¿ytkownikach:");
		System.out.println("a+   dodaj   uprawnienia administratora");
		System.out.println("a-   zdejmij uprawnienia administratora");
		System.out.println("DEL  usuñ u¿ytkownika");
		System.out.println(" ------------------------------------- ");
		System.out.println(" ----     Lista u¿ytkowników:    ----- ");
		
		List<User> users = UserDAO.getData();
		int i=0;
		for (User user : users) {
			System.out.println(++i + ": "+user);
		}
		System.out.println(" ------------------------------------- ");
		System.out.print("> ");
		String polecenie = ConsoleUtils.readLine();
		if(polecenie.equals("")){
			return;
		}
		if(polecenie.contains(" ")){
			String[] skladowePolecenia = polecenie.split(" ");
			if(skladowePolecenia[1].matches("\\d+")){
				int userNumber = Integer.parseInt(skladowePolecenia[1]);
				if(userNumber-1<users.size()){
					User u = users.get(userNumber-1);
					
					switch(skladowePolecenia[0]){
						case "a+":  u.setAdmin(true); break;
						case "a-":  
							if(!User.ROOT_USERNAME.equals(u.getName())) { 
								u.setAdmin(false);
							} else { 
								System.out.println("Nie mo¿na zdj¹æ praw administracyjnych z root'a"); 
							} break;
						case "DEL": 
							if(!User.ROOT_USERNAME.equals(u.getName())) { 
								users.remove(u); 
							} else { 
								System.out.println("Nie mo¿na usun¹æ root'a"); 
							} break; 
						default: System.out.println("Nieznane polecenie: "+skladowePolecenia[0]);
					}
					
				} else {
					System.out.println("Polecenie jest niepoprawne: brak u¿ytkownika o numerze: "+userNumber);
				}
			} else {
				System.out.println("Polecenie jest niepoprawne: numer u¿ytkownika musi byæ liczb¹!");
			}
		} else {
			System.out.println("Polecenie jest niepoprawne lub niekompletne: "+polecenie);
		}
	}
	
	
}
