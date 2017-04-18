package pl.expose.up201703.kolekcje;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Stos {
	
	static class Drzewo {
		String wartosc;
		List<Drzewo> galezie = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception {
		
		File file = new File("..").getCanonicalFile();
		Drzewo drzewo = czytajDrzewoKatalogow(file);

		//wypiszDrzewo(drzewo, "");
		
		Stack<Iterator<Drzewo>> stos = new Stack<>();
		Iterator<Drzewo> i = drzewo.galezie.iterator();
		stos.push(i);
		do{
			StringBuilder sb = new StringBuilder();
			for(int a=0; a<stos.size(); a++){
				sb.append(" | ");
			}
			if(i.hasNext()){
				System.out.println(sb + drzewo.wartosc);
				drzewo = i.next();
				stos.push(i);
				i = drzewo.galezie.iterator();
			} else {
				i = stos.pop();
			}
			
		} while (!stos.isEmpty());
		
	}

	static void wypiszDrzewo(Drzewo drzewo, String wciecie){
		System.out.println(wciecie+drzewo.wartosc);
		for(Drzewo podDrzewo : drzewo.galezie){
			wypiszDrzewo(podDrzewo, wciecie+" | ");
		}
	}
	
	static Drzewo czytajDrzewoKatalogow(File file){
		boolean czyKatalog = !file.isFile();
		Drzewo drzewo = new Drzewo();
		drzewo.wartosc = file.getName();
		
		if(czyKatalog){
			for(File f : file.listFiles()){
				drzewo.galezie.add(czytajDrzewoKatalogow(f));
			}
		}
		return drzewo;
	}
	
}
