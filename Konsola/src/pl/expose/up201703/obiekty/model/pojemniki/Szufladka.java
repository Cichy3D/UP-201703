package pl.expose.up201703.obiekty.model.pojemniki;

public class Szufladka<T> implements Pojemnik<T> {
	
	private T obj = null;

	@Override
	public void dodaj(T o) {
		if(obj != null){
			System.out.println("Nie da si� wsadzi� do szufladki "+ o);
			System.out.println("Szufladka ju� jest zaj�ta!");
			System.out.println("W szufladce jest " + obj);
		} else {
			obj = o;
		}
	}

	@Override
	public void usun(T o) {
		if(obj != null && obj.equals(o)){
			obj = null;
		} else { // obj == null || !obj.equals(o) 
			System.out.println("Nie da si� usun�� z szufladki "+ o);
			System.out.println("W szufladce jest teraz " + (obj==null ? "pusto" : obj ) );
		}
	}

	@Override
	public void wypisz() {
		System.out.println("Stan szufladki:\n    " + (obj==null ? "pusto" : obj ) );
	}

}
