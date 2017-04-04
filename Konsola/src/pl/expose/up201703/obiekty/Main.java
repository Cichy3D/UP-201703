package pl.expose.up201703.obiekty;

import pl.expose.up201703.obiekty.model.Kolor;

public class Main {

	public static void main(String[] args) {

		for(Kolor k : Kolor.values()){
			System.out.println(k + " : " + k.webColor());
		}
		
		// switch( k ){
		// case CZERWONY: System.out.println("Ogieñ"); break;
		// case NIEBIESKI: System.out.println("Woda"); break;
		// case ZIELONY: System.out.println("Trawa"); break;
		// default: System.out.println("Nie znam tego koloru");
		// }

	}

}
