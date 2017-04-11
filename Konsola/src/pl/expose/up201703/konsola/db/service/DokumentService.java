package pl.expose.up201703.konsola.db.service;

import pl.expose.up201703.konsola.db.model.Document;

public class DokumentService {

	public static void appendToDocument(Document document, String text) {
		StringBuilder sb = new StringBuilder(document.getContent());
		sb.append("\n");
		sb.append(text);
		document.setContent(sb.toString());
	}


	
}
