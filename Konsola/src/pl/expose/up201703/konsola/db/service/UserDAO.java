package pl.expose.up201703.konsola.db.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pl.expose.up201703.konsola.db.model.User;

public class UserDAO {

	final static private File PLIK = new File("dane.dat");
	static private List<User> data = null;
	
	public static void saveData() throws Exception{
		FileOutputStream fileOut = new FileOutputStream(PLIK);
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
		oos.writeObject(data);
		oos.flush();
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void loadData() throws Exception{
		if(PLIK.exists()){
			InputStream is = new FileInputStream(PLIK);
			ObjectInputStream ois = new ObjectInputStream(is);
			data = (List<User>)ois.readObject();
			ois.close();
		} else {
			data = new ArrayList<>();
		}
	}
	
	public static List<User> getData(){
		return data;
	}
}
