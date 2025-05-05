package com.demo.dq;

import java.util.Iterator;
import java.util.UUID;

public class Producer extends Thread {

	private String name;
	private ClusterService clusterService;

	public Producer(ClusterService clusterService) {
		super();
		this.name = UUID.randomUUID().toString();
		this.clusterService = clusterService;
	}
	
	@Override
	public void run() {
		for (var i = 0; i < 5; i++) {
			String message = "Producer " + this.name + " sent : " + " CHU " + String.valueOf(i);
		}
	}
	
	
}
