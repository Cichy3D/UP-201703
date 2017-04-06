package pl.expose.up201703.watki;

public class Przyklad {

	static class Watek extends Thread{

		private int numer;

		public Watek(int numer) {
			super();
			this.numer = numer;
		}

		@Override
		public void run() {
			System.out.println("W¹tek "+numer+": Hello z w¹tku!!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("W¹tek "+numer+": Obudzi³em siê!");
			}
			System.out.println("W¹tek "+numer+": Koniec w¹tku.");
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");

		Watek watek1 = new Watek(1);
		watek1.start();
		
		Watek watek = new Watek(2);
		//watek.setDaemon(true);
		watek.start();
		watek.join(1000);
		if(watek.isAlive()){
			watek.interrupt();
		}
		watek.join();
		
		System.out.println("End.");
	}

}
