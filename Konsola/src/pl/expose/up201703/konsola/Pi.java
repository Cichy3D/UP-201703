package pl.expose.up201703.konsola;

public class Pi {

	final static long N = 80000000L;
	final static long N_KWADRAT = ((long)N)*N;
	
	public static void main(String[] args) {
		System.out.println("Start");

		double suma = 0;
		for(long x=0; x<N; x++){
			suma += Math.sqrt( N_KWADRAT  - x*x );
		}
		
		System.out.println("suma jest " + 4.0 * suma / N_KWADRAT);
		System.out.println("          " + Math.PI);
		
		
		System.out.println("End.");
	}

}
