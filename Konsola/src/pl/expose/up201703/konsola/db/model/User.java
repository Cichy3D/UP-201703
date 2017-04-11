package pl.expose.up201703.konsola.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = 12563456245634L;
	public static final String ROOT_USERNAME = "root";
	
	private String name;
	private boolean admin;
	private List<Document> docs;
	
	public User() {
		docs = new ArrayList<>();
	}

	public User(String name) {
		this();
		this.name = name;
		admin = ROOT_USERNAME.equals(name);
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public List<Document> getDocs() {
		return docs;
	}

	@Override
	public String toString() {
//		int suma = 0;
//		for(Document d : docs){
//			if(d.getContent()!=null){
//				suma += d.getContent().length();
//			}
//		}
		
		int suma = docs.stream()
				.filter(d->d.getContent()!=null)
				.map(Document::getContent)
				.mapToInt(String::length)
				.sum();
		
		return (admin?"A":" ")+"   "+name+"   "+docs.size()+": "+suma;
	}
	
}
