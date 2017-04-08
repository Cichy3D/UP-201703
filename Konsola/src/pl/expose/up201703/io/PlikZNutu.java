package pl.expose.up201703.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PlikZNutu {

	public static void main(String[] args) throws IOException {
		String nazwa = "https://www.wp.pl/";
		
		URL url = new URL(nazwa);
		InputStream is = url.openStream();
		
//		File f = new File("obraz.png");
//		f.createNewFile();
//		OutputStream out = new FileOutputStream(f);
		
		byte[] buf = new byte[1024];
		while(is.read(buf)>-1){
			//out.write(buf);
			String s = new String(buf, "utf-8");
			System.out.print(s);
		}
//		out.flush();
//		out.close();
		is.close();

		
//		URL website = new URL(nazwa);
//		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//		FileOutputStream fos = new FileOutputStream("obraz.png");
//		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		
	}

}
