package pl.expose.up201703.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Cat {

	public static void main(String[] args) throws IOException {
		if(args.length<1){
			System.out.println("B��d: brak nazwy pliku.");
			System.exit(1);
		}
		File file = new File(args[0]);
		if(!file.exists()){
			System.out.println("B��d: podany plik nie istnieje.");
			System.out.println("Szukano pliku: "+args[0]);
			System.exit(2);
		}
		if(!file.isFile()){
			System.out.println("B��d: wskazana �cie�ka nie wskazuje pliku.");
			System.out.println("Szukano pliku: "+args[0]);
			System.exit(3);
		}
		file = file.getCanonicalFile();
		if(!file.canRead()){
			System.out.println("B��d: nie mo�na czyta� z pliku: " + file.getAbsolutePath());
		}
		
		InputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);
		while(scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}
		scanner.close();
		fis.close();
	}

}
