package pl.expose.up201703.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.expose.up201703.baza.model.Dokument;
import pl.expose.up201703.baza.model.Osoba;

public class ObiektyZBazy {

	public static void main(String[] args) throws Exception {
		
		List<Osoba> osoby = new ArrayList<>();
		List<Dokument> dokumenty = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/baza?user=root&password=password&useSSL=false");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM osoby");
		
		while(rs.next()){
			Osoba osoba = new Osoba(rs);
			
			osoby.add(osoba);
		}
		rs.close();

		for(Osoba o : osoby){
			System.out.println(o);
		}
		
		
		
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM dokumenty");
		
		while(rs.next()){
			Dokument d = new Dokument(rs);
			dokumenty.add(d);
			
			long autorId  = rs.getLong("autor");
			System.out.println("dla dokumentu "+d.getId()+" autorId = "+autorId);
			
			for(Osoba o : osoby){
				if(o.getId().equals(autorId)){
					d.setAutor( o );
					break;
				}
			}
		}
		rs.close();

		for(Dokument d : dokumenty){
			System.out.println(d);
		}

	}

}
