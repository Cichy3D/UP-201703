package pl.expose.up201703.baza;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class Odczyt {

	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/baza?user=root&password=password&useSSL=false");
		
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("DESCRIBE osoby");
		while(rs.next()){
			String  nazwa   = rs.getString ("field");
			System.out.print(nazwa + " | ");
		}
		rs.close();
		System.out.println();
		
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM osoby");

		
		//System.out.printf("%3s | %20s | %4s | %4s | %2s\n","id", "nazwa", "wiek", "plec", "czy_zyje");
		while(rs.next()){
			long    id      = rs.getLong   ("id");
			String  nazwa   = rs.getString ("nazwa");
			long    wiek    = rs.getLong   ("wiek");
			String  plec    = rs.getString ("plec");
			boolean czyZyje = rs.getBoolean("czy_zyje");
			
			System.out.printf("%3d | %20s | %4d | %4s | %2s\n", id , nazwa , wiek , plec , czyZyje ? "T" : "N"  );
		}
		rs.close();

		
//		System.out.println("Nowa osoba,\nPodaj nazwê osoby:");
//		Scanner scanner = new Scanner(System.in);
//		String  nazwa   = scanner.nextLine();
//		System.out.println("Podaj wiek osoby:");
//		long    wiek    = scanner.nextInt();
//		
//		stmt = conn.createStatement();
//		int rows = stmt.executeUpdate("INSERT INTO osoby (nazwa, wiek) VALUES ( \""+ nazwa +"\",  "+ wiek +" )");
//		
//		System.out.println("Wierszy zminionych: "+rows);
		
		conn.close();
		System.out.println("End.");
	}

}
