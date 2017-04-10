package pl.expose.up201703.konsola.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public class Document implements Serializable{

	private static final long serialVersionUID = 7151823301521791029L;
	
	private String title;
	private String content;
	private Date date;
	
	public Document() {
		date = new Date();
	}

	public Document(String title, String content) {
		this();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		//int len = ( this.content==null ? "" : this.content ).length();
		int len = Optional.ofNullable(this.content)
				.map(String::length)
				.orElse(0);
		
		return String.format("%-70s%8d", title, len);
	}

	
}
