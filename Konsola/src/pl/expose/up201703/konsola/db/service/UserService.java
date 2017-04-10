package pl.expose.up201703.konsola.db.service;

import pl.expose.up201703.konsola.db.model.User;

public class UserService {

	public static User getUser(String name){
		for (User u : UserDAO.getData()) {
			if(name.equals(u.getName())){
				return u;
			}
		}
		return null;
	}

	public static void listUsers() {
		//TODO
		
	}
	
}
