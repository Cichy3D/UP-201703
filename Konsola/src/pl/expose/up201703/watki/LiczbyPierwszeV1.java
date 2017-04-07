package pl.expose.up201703.watki;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import pl.expose.up201703.watki.service.PulaWatkow;

public class LiczbyPierwszeV1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");

		PulaWatkow pula = new PulaWatkow();
		pula.start();
		final ConcurrentLinkedQueue<Integer> wynik = new ConcurrentLinkedQueue<>();
		
		for(int liczba = 1001; liczba<10000; liczba+=2){
			synchronized (pula.zadania) {
				final int x = liczba;
				pula.zadania.add(numerWatku -> {
					for(int dzielnik=2; dzielnik<(x/2+1); dzielnik++){
						if(x % dzielnik == 0){
							return;
						}
					}
					wynik.offer(x);
				});
			}
		}
		System.out.println("Zadania dodano");
		pula.join(10);
		pula.interrupt();
		pula.join();
		
		List<Integer> tmpList = new LinkedList<>();
		for(Integer liczba : wynik){
			tmpList.add(liczba);
			if(tmpList.size()>19){
				System.out.println(tmpList);
				tmpList.clear();
			}
		}
		System.out.println(tmpList);
		
		
		System.out.println("End.");
	}

}
