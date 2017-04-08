package pl.expose.up201703.watki;

import java.util.LinkedList;

public class ProducentKonsument {
	
	static LinkedList<String> kolejka = new LinkedList<>();

	static class Producent extends Thread{
		public void run() {
			String ciacha = "ptyœ,eklerka,petite berie,p¹czki,WZtka,sernik,szarlotka,tarta,makowiec,kremówka,bajaderka";
			String[] tablica = ciacha.split(",");
			for (String ciacho : tablica) {
				synchronized (kolejka) {
					kolejka.add(ciacho);
				}
				System.out.println("Wyprodukowa³em: "+ciacho);
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	static class Konsument extends Thread{
		public void run() {
			while(true){
				String ciacho = null;
				synchronized (kolejka) {
					if(!kolejka.isEmpty()){
						ciacho = kolejka.poll();
					}
				}
				System.out.println("Zjad³em "+ciacho);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		Producent producent = new Producent();
		producent.start();
		
		Konsument konsument = new Konsument();
		konsument.setDaemon(true);
		konsument.start();
		
		producent.join();
		while(!kolejka.isEmpty()){
			Thread.sleep(10);
		}
		
		System.out.println("End.");
	}
	
}
