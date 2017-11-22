package com.synchronousQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class JavaSynchronousQueueExample {

	public static void main(String args[]) {

		try {
			final SynchronousQueue<String> queue = new SynchronousQueue<String>();
			CountDownLatch latch = new CountDownLatch(2);

			// starting publisher thread
			Thread t1 = new Thread(new QueueProducer(queue, latch));

			// starting consumer thread
			Thread t2 = new Thread(new QueueConsumer(queue, latch));

			t1.start();
			t2.start();

			latch.await();

			System.out.println("End of main program");

		}

		catch (Throwable t) {

		}

	}

	// Singleton example
	/*
	 * public enum EasySingleton{ INSTANCE; }
	 */

}
