package pl.expose.up201703.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import pl.expose.up201703.obiekty.model.baza.Osoba;

public class CzytajOsobe {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("osoba.dat");
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Osoba osoba = (Osoba)ois.readObject();
		ois.close();
		
		System.out.println(osoba);
	}

}
