package com.demo.dq;

import java.util.Date;
import java.util.UUID;

public class Message {
	
	private String id;
	private String text;
	private Date date;
	private MessageAcknowledgementCallback callback;
	
	public Message(String text) {
		super();
		this.id = UUID.randomUUID().toString();
		this.text = text;
		this.date = new Date(System.currentTimeMillis());
	}
	
	public void ack() {
		callback.receivedMessage(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCallback(MessageAcknowledgementCallback callback) {
		this.callback = callback;
	}
}
