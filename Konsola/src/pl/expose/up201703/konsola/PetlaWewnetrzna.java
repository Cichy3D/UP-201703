package pl.expose.up201703.konsola;

public class PetlaWewnetrzna {

	final static long N = 800000000;
	final static long N_KWADRAT = ((long)N)*N;
	
	public static void main(String[] args) {
		System.out.println("Start");

		long suma = 0;
		long lastZeroPosition = 0;
		for(long y=N-1; y>=0; y--){
			long yKwadrat = y*y;
			
			if(lastZeroPosition > 0){
				suma = suma + lastZeroPosition - 1;
			}
			for(long x=lastZeroPosition; x<N; x++){
				if(yKwadrat <= N_KWADRAT  - x*x){
					suma = suma + 1;
				} else {
					lastZeroPosition = x;
					break;
				}
			}
		}
		
		System.out.println("suma jest " + 4.0 * suma / N_KWADRAT);
		System.out.println("          " + Math.PI);
		
		
		System.out.println("End.");
	}

}
