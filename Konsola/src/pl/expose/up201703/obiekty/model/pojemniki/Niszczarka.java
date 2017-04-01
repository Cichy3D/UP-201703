package pl.expose.up201703.obiekty.model.pojemniki;

public class Niszczarka implements Pojemnik {

	@Override
	public void dodaj(Object o) {
		System.out.println("Zniszczono: "+o);
	}

	@Override
	public void usun(Object o) {
		System.out.println("Nie da siê usun¹æ z niszczarki obiektu "+o);
	}

	@Override
	public void wypisz() {
		System.out.println("Stan Niszczarki:\n    Niszczarka jest pusta");
	}

}
