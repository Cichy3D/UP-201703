package pl.expose.up201703.konsola;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibon {

	static BigInteger[] bufor;
	
	public static void main(String[] args) {
		System.out.println("Start");

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		bufor = new BigInteger[n+1];
		
		BigInteger s = fibon(n);
		System.out.println(s);
		
		scanner.close();
		System.out.println("End.");
	}
	
	static BigInteger fibon(int n){
		if(bufor[n] != null){
			return bufor[n];
		}

		BigInteger s = new BigInteger(""+n);
		if(n>1){
			s = new BigInteger("0").add(fibon(n-1)).add(fibon(n-2));
		}
		bufor[n] = s;
		return s;
	}
	

}
