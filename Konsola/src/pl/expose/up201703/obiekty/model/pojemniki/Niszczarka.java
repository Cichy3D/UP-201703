package pl.expose.up201703.obiekty.model.pojemniki;

public class Niszczarka<T> implements Pojemnik<T> {

	@Override
	public void dodaj(T o) {
		System.out.println("Zniszczono: "+o);
	}

	@Override
	public void usun(T o) {
		System.out.println("Nie da siê usun¹æ z niszczarki obiektu "+o);
	}

	@Override
	public void wypisz() {
		System.out.println("Stan Niszczarki:\n    Niszczarka jest pusta");
	}

}
