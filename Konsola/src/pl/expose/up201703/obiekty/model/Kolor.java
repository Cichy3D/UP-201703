package pl.expose.up201703.obiekty.model;

import java.util.Arrays;
import java.util.List;

public enum Kolor {
	
	BIALY(255, 255, 255), CZARNY(0, 0, 0),
	CZERWONY(255, 0, 0), ZIELONY(0, 255, 0), NIEBIESKI(0, 0, 255),
	ZOLTY(255, 255, 0), FIOLET(255, 0, 255), SELEDYN(0, 255, 255);

	private int r, g, b;

	private Kolor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void info() {
		System.out.println("r,g,b = " + r + ", " + g + ", " + b);
	}

	public String webColor() {
		List<Integer> t = Arrays.asList(new Integer[]{r, g, b});
		String result = "#";
		for (int k : t) {
			result += to2DigitHex(k);
		}
		return result;
	}

	private String to2DigitHex(int k) {
		String hex = Integer.toHexString(k);
		if(hex.length()<2){
			hex = "0" + hex;
		}
		return hex;
	}
}
