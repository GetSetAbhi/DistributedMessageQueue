package com.demo.dq;

public interface MessageAcknowledgementCallback {

	public void receivedMessage(Message message);
}
