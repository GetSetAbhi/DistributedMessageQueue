package com.demo.dq;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
	
	private String id;
	private Map<String, MessageQueue> queues;

	public Broker() {
		this.id = UUID.randomUUID().toString();
		this.queues = new ConcurrentHashMap<>();
	}
	
	private synchronized void createTopic(String topicName) {
		MessageQueue dq = new MessageQueue();
		this.queues.put(topicName, dq);
	}
	
	public synchronized void sendMessage(String topicName, Message message) {
		if (!this.queues.containsKey(topicName)) {
			this.createTopic(topicName);
		}
		this.queues.get(topicName).appendMessage(message);;
	}
	
	public List<Message> getMessagesFromTopic(String topicName) {
		if (this.queues != null && this.queues.containsKey(topicName)) {
			this.queues.get(topicName).getUnreadMessage();
		}
		return Collections.emptyList();
	}
}
