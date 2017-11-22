package com.synchronousQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class QueueProducer implements Runnable{

	private SynchronousQueue<String> queue;
	private CountDownLatch latch;
	
	public QueueProducer(SynchronousQueue<String> queue, CountDownLatch latch) {
		this.queue=queue;
		this.latch = latch;
	}
	@Override
	public void run() {

		String event = "SYNCHRONOUS_EVENT";
		String another_event ="ANOTHER_EVENT";
		try {
			queue.put(event);
			System.out.printf("[%s] published event : %s %n", Thread
					.currentThread().getName(), event);
			
			queue.put(another_event);
			System.out.printf("[%s] published event : %s %n", Thread
					.currentThread().getName(), another_event);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			latch.countDown();
		}
	
		
	}

}
