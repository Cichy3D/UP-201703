package pl.expose.up201703.watki.service;

import java.util.LinkedList;
import java.util.Random;
import java.util.function.Consumer;

public class PulaWatkow extends Thread{

	private static final int CORES = Runtime.getRuntime().availableProcessors();
	private final WatekRoboczy[] tab = new WatekRoboczy[CORES];
	public LinkedList<Consumer<Integer>> zadania = new LinkedList<>();
	
	public void run(){
		for(int i=0; i<tab.length; i++){
			tab[i] = new WatekRoboczy(i+1);
			tab[i].start();
		}
		System.out.println("Pula w¹tków wystartowa³a");
		boolean czyMoznaZakonczyc = false;
		while(!czyMoznaZakonczyc || !zadania.isEmpty()){
			
			for(WatekRoboczy w : tab){
				if(w.zadanie == null){
					synchronized (zadania) {
						if(!zadania.isEmpty()){
							w.zadanie = zadania.poll();
						}
					}
					if(w.zadanie != null){
						w.interrupt();
					}
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				czyMoznaZakonczyc = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		final Random random = new Random();
		
		PulaWatkow pula = new PulaWatkow();
		pula.start();

		for(int i = 0; i<100; i++){
			final int nz = i;
			synchronized (pula.zadania) {
				pula.zadania.add((n) -> {
					System.out.println("Zadanie " + nz + " wykona siê w w¹tku " + n);
					try {
						int czas = random.nextInt(2000);
						System.out.println("W¹tek "+ n +" czeka "+ czas + " ms.");
						Thread.sleep(czas);
					} catch (InterruptedException e) {}
					System.out.println("Zadanie " + nz + " w w¹tku " + n + " zakoñczy³o siê!");
				});
				System.out.println("iloœæ zadañ: "+pula.zadania.size());
			}
			Thread.sleep(200);
		}
		pula.interrupt();

		System.out.println("End.");
	}

}
