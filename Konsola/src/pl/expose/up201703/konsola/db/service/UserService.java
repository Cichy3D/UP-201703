package pl.expose.up201703.konsola.db.service;

import pl.expose.up201703.konsola.db.model.Document;
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

	public static void addDocument(User user, Document document) {
		user.getDocs().add(document);
	}

	public static void removeDocument(User user, Document document) {
		user.getDocs().remove(document);
	}
	
}
