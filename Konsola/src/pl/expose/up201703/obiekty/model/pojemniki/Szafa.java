package pl.expose.up201703.obiekty.model.pojemniki;

public class Szafa<T> implements Pojemnik<T> {
	
	private Object[] tab;
	
	public Szafa(int N){
		tab = new Object[N];
	}

	public void dodaj(T o) {
		for(int i=0; i<tab.length; i++){
			if(tab[i] == null){
				tab[i] = o;
				return;
			}
		}
		System.out.println("Szafa jest pe³na, nie mo¿na w³o¿yæ "+ o);
	}

	public void usun(T o) {
		for(int i=0; i<tab.length; i++){
			if(tab[i] != null && tab[i].equals(o)){
				tab[i] = null;
				return;
			}
		}
		System.out.println("Nie mo¿na usun¹æ. Szafa nie zawiera "+ o);
	}

	public void wypisz() {
		System.out.println("Stan szafy:");
		boolean pusto = true;
		for(int i=0; i<tab.length; i++){
			if(tab[i] != null){
				System.out.println("    " + tab[i]);
				pusto = false;
			}
		}
		if(pusto){
			System.out.println("    W szafie jest pusto!");
		}
	}
	
	public int getN(){
		return tab.length;
	}

}
