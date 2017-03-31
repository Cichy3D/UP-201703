package pl.expose.up201703.baza.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Osoba {

	private Long id;
	private String nazwa;
	private int wiek;
	private String plec;
	private boolean zyje;

	public Osoba() {
	}

	public Osoba(Long id, String nazwa, int wiek, String plec, boolean zyje) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.wiek = wiek;
		this.plec = plec;
		this.zyje = zyje;
	}

	public Osoba(ResultSet row) throws SQLException{
		id    = row.getLong   ("id");
		nazwa = row.getString ("nazwa");
		wiek  = row.getInt    ("wiek");
		plec  = row.getString ("plec");
		zyje  = row.getBoolean("czy_zyje");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public boolean isZyje() {
		return zyje;
	}

	public void setZyje(boolean zyje) {
		this.zyje = zyje;
	}

	@Override
	public String toString() {
		return "Osoba [id=" + id + ", nazwa=" + nazwa + ", wiek=" + wiek + ", plec=" + plec + ", zyje="
				+ (zyje ? "Tak" : "Nie") + "]";
	}

}
