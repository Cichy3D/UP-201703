package pl.expose.up201703.konsola;

public class Silnia {

	public static void main(String[] args) {
		System.out.println("Start");

		long silnia = 1;
		for(int i=2; i<10; i++){
			silnia = silnia * i;
			
			System.out.println(i + "! = " + silnia);
		}
		
		System.out.println("End.");
	}

}
