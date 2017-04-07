package pl.expose.up201703.watki;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WatekPI {

	private static final long DOKLADNOSC = 10000000000L;
	final static ConcurrentLinkedQueue<Long> wynik = new ConcurrentLinkedQueue<>();
	
	static class Watek extends Thread{
		public void run(){
			Random rand = new Random();
			long suma = 0;
			for(long j=0; j<DOKLADNOSC; j++){
				double x = rand.nextDouble();
				double y = rand.nextDouble();
				if(x*x+y*y<1) {
					suma++;
				}
			}
			wynik.offer(suma);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		
		Watek[] tab = new Watek[4];
		for(int i = 0; i<tab.length; i++){
			tab[i] = new Watek();
			tab[i].start();
		}
		
		System.out.println("Zadania dodano");
		
		for(int i = 0; i<tab.length; i++){
			tab[i].join();
		}

		double suma = 0;
		for(Long liczba : wynik){
			suma += ((double)liczba)/DOKLADNOSC;
		}
		suma /= wynik.size();
		suma *= 4;
		System.out.println(suma);
		System.out.println(Math.PI);
		
		System.out.println("End.");
	}

}
