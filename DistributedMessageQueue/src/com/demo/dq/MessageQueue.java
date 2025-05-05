package com.demo.dq;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MessageQueue implements MessageAcknowledgementCallback {

	private Deque<Message> messageQueue;

	public MessageQueue() {
		super();
		this.messageQueue = new ConcurrentLinkedDeque<>();
	}

	@Override
	public  void receivedMessage(Message message) {
		if (this.messageQueue.contains(message)) {
			this.messageQueue.remove(message);
		}
	}
	
	public void appendMessage(Message message) {
		this.messageQueue.addLast(message);
		message.setCallback(this);
	}
	
	public List<Message> getUnreadMessage() {
		List<Message> messages = new ArrayList<>();
		while (this.messageQueue != null && this.messageQueue.size() > 0) {
			messages.add(this.messageQueue.pollFirst());
		}
		return messages;
	}
}
