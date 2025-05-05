package com.demo.dq;

import java.util.ArrayList;
import java.util.List;

public class ClusterService {

	private List<Broker> brokers;
	
	public ClusterService() {
		this.brokers = new ArrayList<>();
	}
	
	private synchronized Broker getBroker(Topic topic) {
		int index = topic.getName().hashCode() % this.brokers.size();
		return this.brokers.get(index);
	} 
	
	private void addBroker() {
		this.brokers.add(new Broker());
	}
	
	public synchronized void sendMessage(Topic topic, Message message) {
		Broker broker = this.getBroker(topic);
		broker.sendMessage(topic.getName(), message);
	}
	
	public synchronized List<Message> listenForMessage(Topic topic) {
		Broker broker = this.getBroker(topic);
		return broker.getMessagesFromTopic(topic.getName());
	}
}
