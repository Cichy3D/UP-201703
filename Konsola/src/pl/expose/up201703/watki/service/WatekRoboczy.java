package pl.expose.up201703.watki.service;

import java.util.function.Consumer;

public class WatekRoboczy extends Thread {

	public Consumer<Integer> zadanie = null;
	private final Integer numerWatku;
	
	public WatekRoboczy(Integer numerWatku){
		this.numerWatku = numerWatku;
		setDaemon(true);
	}
	
	public void run() {
        while(true){
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
        	
        	if(zadanie!=null){
        		zadanie.accept(numerWatku);
        	}
        }
    }

	
}
