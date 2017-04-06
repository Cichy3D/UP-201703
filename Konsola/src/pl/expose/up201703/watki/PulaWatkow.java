package pl.expose.up201703.watki;

import java.util.LinkedList;
import java.util.Random;
import java.util.function.Consumer;

import pl.expose.up201703.watki.service.WatekRoboczy;

public class PulaWatkow {

	static LinkedList<Consumer<Integer>> zadania = new LinkedList<>();
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		final Random random = new Random();
		
		int cores = Runtime.getRuntime().availableProcessors();
		WatekRoboczy[] tab = new WatekRoboczy[cores];
		
		
		for(int i = 0; i<100; i++){
			final int nz = i;
			zadania.add((n)->{
				System.out.println("Zadanie "+nz+" wykona siê w w¹tku "+n);
				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException e) {}
				System.out.println("Zadanie "+nz+" w w¹tku "+n+" zakoñczy³o siê!");
			});
			Thread.sleep(200);
			
		}

		
		System.out.println("End.");
	}

}
