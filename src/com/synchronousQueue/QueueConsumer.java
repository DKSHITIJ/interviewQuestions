package com.synchronousQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class QueueConsumer implements Runnable {

	private SynchronousQueue<String> queue;
	private CountDownLatch latch;

	public QueueConsumer(SynchronousQueue<String> queue, CountDownLatch latch) {
		this.queue=queue;
		this.latch=latch;
	}

	@Override
	public void run() {
		try {
			String event = queue.take();
			// thread will block here
			System.out.printf("[%s] consumed event : %s %n", Thread
					.currentThread().getName(), event);
			event = queue.take();
			System.out.printf("[%s] consumed event : %s %n", Thread
					.currentThread().getName(), event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			latch.countDown();
		}
	
	}
	
}
