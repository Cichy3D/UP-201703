package pl.expose.up201703.webCzat.model;

import java.util.Date;

public class ChatMessage {

	private Date date;
	private String userName;
	private String message;
	
	public ChatMessage(String name, String message) {
		date = new Date();
		this.userName = name;
		this.message = message;
	}

	public ChatMessage() {
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ChatMessage [date=" + date + ", userName=" + userName + ", message=" + message + "]";
	}
}
