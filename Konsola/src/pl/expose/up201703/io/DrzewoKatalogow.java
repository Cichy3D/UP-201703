package pl.expose.up201703.io;

import java.io.File;
import java.io.IOException;

public class DrzewoKatalogow {

	static void wypiszDrzewoKatalogow(File file, String wciecie){
		boolean czyKatalog = !file.isFile();
		boolean czyUkryty  =  file.isHidden();
		System.out.printf("%-70s", (czyUkryty?"H":" ")+(czyKatalog?"D":" ")+" "+wciecie + file.getName());
		if(czyKatalog){
			System.out.println();
			for(File f : file.listFiles()){
				wypiszDrzewoKatalogow(f, wciecie+" | ");
			}
		} else {
			String str = " kMGT";
			long len = file.length();
			int exp = 0;
			while(len>=1024 && exp<str.length()) {
				len /= 1024;
				exp++;
			}
			System.out.printf("%5d %1sB\n", len, str.charAt(exp));
		}
		
	}

	public static void main(String[] args) throws IOException {
		File file = new File("..").getCanonicalFile();
		wypiszDrzewoKatalogow(file, "");
	}

}
