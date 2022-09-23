package com.example.learnwebsocketreceiver.domain;

public class ChatRequest {

	private String chatUser;
	private String message;
	public String getChatUser() {
		return chatUser;
	}
	public void setChatUser(String chatUser) {
		this.chatUser = chatUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
