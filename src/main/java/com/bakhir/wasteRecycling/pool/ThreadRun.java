package com.bakhir.wasteRecycling.pool;


public class ThreadRun {

	public static void main(String[] args) throws InterruptedException {	
		
		for(int i=1; i < 10; i++)
	        new MyThread("Thread " + i ).start();
		for(int i=1; i < 3; i++)
	        new MyThread2().run();

	}

}
