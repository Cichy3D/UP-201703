package pl.expose.up201703.konsola.db.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUtils {

	private static Scanner scanner = new Scanner(System.in);
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String readLine(){
		String result;
		result = scanner.nextLine();
		return result;
	}
	
	public static void close(){
		scanner.close();
	}
	
	public static String formatDate(Date date){
		return df.format(date);
	}
}
