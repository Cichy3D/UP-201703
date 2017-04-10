package pl.expose.up201703.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import pl.expose.up201703.obiekty.model.baza.Osoba;

public class ZapiszOsobe {

	public static void main(String[] args) throws Exception {
		Osoba osoba = new Osoba("Ala", 213, "K", true);

		OutputStream os = new FileOutputStream("osoba.dat");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(osoba);
		oos.flush();
		oos.close();
	}

}
