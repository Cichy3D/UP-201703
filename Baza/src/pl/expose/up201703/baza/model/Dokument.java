package pl.expose.up201703.baza.model;

import java.util.Date;

public class Dokument {

	private Long id;
	private String tytul;
	private String tresc;
	private Osoba autor;
	private Date data;
	
	public Dokument() {
	}

	public Dokument(Long id, String tytul, String tresc, Osoba autor, Date data) {
		super();
		this.id = id;
		this.tytul = tytul;
		this.tresc = tresc;
		this.autor = autor;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public Osoba getAutor() {
		return autor;
	}

	public void setAutor(Osoba autor) {
		this.autor = autor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Dokument [id=" + id + ", tytul=" + tytul + ", tresc=" + tresc + ", autor=" + autor + ", data=" + data
				+ "]";
	}
	
	
}
