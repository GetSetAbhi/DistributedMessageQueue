package com.demo.dq;

public class DriverClass {

	public static void main(String[] args) {

		ClusterService cluster = new ClusterService();
		
		Producer p1 = new Producer(cluster);
		Producer p2 = new Producer(cluster);
		
		Consumer c1 = new Consumer();
		Consumer c2 = new Consumer();
	}

}
