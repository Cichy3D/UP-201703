package pl.expose.up201703.watki;

import java.util.Random;

public class TablicaWatkow {

	static Random random = new Random();
	
	static class Watek extends Thread{

		private int numer;

		public Watek(int numer) {
			super();
			this.numer = numer;
		}

		@Override
		public void run() {
			int czas;
			synchronized (random) {
				czas = random.nextInt(5000)+1000;
			}
			System.out.println("W¹tek "+numer+": czekam "+czas+" milisekund." );
			try {
				Thread.sleep(czas);
			} catch (InterruptedException e) {
				System.out.println("W¹tek "+numer+": Obudzi³em siê!");
			}
			System.out.println("W¹tek "+numer+": Koniec w¹tku.");
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");

		Watek[] tab = new Watek[10];
		for(int i=0; i<tab.length; i++){
			Watek watek = new Watek(i);
			tab[i] = watek;
		}
		
		for(int i=0; i<tab.length; i++){
			tab[i].start();
		}
		
		tab[0].join();
		for(int i=0; i<tab.length; i++){
			if(tab[i].isAlive()){
				tab[i].interrupt();
			}
		}
		
		for(int i=0; i<tab.length; i++){
			tab[i].join();
		}
		
		System.out.println("End.");
	}

}
