package pl.expose.up201703.obiekty.model.baza;

public class Osoba {
	
	private Long id;
	private String nazwa;
	private int wiek;
	private String plec;
	private boolean zyje;
	
	public Osoba() {
	}
	
	public Osoba(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public Osoba(String nazwa, int wiek) {
		this(nazwa);
		this.wiek = wiek;
	}

	public Osoba(String nazwa, int wiek, String plec, boolean zyje) {
		this(nazwa, wiek);
		this.plec = plec;
		this.zyje = zyje;
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
		return "Osoba [nazwa=" + nazwa + ", wiek=" + wiek + ", plec=" + plec + ", zyje=" + (zyje ? "Tak" : "Nie") + "]";
	}
	
	
}
