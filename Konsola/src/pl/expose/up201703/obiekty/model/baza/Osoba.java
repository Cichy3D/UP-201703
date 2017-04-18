package pl.expose.up201703.obiekty.model.baza;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Osoba implements Externalizable {
	
	private static final long serialVersionUID = 2L;
	private long id = 0;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readLong();
		wiek = in.readInt();
		nazwa = (String) in.readObject();
		plec = (String) in.readObject();
		zyje = wiek < 125;
		
		Date czas = (Date)in.readObject();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("czytam osobê zapisan¹ w chwili: "+df.format(czas));
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(id);
		out.writeInt(wiek);
		out.writeObject(nazwa);
		out.writeObject(plec);
		
		out.writeObject(new Date());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Osoba other = (Osoba) obj;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		return true;
	}
	
	
}
