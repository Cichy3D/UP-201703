package pl.expose.up201703.konsola;

public class KolkoIKrzyzyk {
	
	static final int KOLKO = 1;
	static final int KRZYZYK = 2;
	static int[][] mapa = new int[3][3];

	public static void main(String[] args) {
		System.out.println("Start.");
		
		int aktualnyGracz = KOLKO;
		
		mapa[2][1] = KOLKO;
		mapa[0][2] = KRZYZYK;
		for(int y=0; y<mapa.length; y++){
			for(int x=0; x<mapa[y].length; x++){
				
				if(mapa[y][x] == KOLKO){
					System.out.print("O");
				} else
				if(mapa[y][x] == KRZYZYK){
					System.out.print("X");
				} else {
					if(y<mapa.length-1){
						System.out.print("_");
					} else {
						System.out.print(" ");
					}
				}
				
				if(x<mapa[y].length-1){
					System.out.print("|");
				}
			}
			System.out.println("       "+(y*3+1)+"|"+(y*3+2)+"|"+(y*3+3)+"");
		}
		
		
		System.out.println("End.");
	}

}
