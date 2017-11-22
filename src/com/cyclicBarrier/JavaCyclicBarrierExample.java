package com.cyclicBarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class JavaCyclicBarrierExample {
	
	
	public static void main(String[] args) {
		
		//3 threads are part of the barrier, ServiceOne, ServiceTwo and this main thread calling them.
		final CyclicBarrier barrier = new CyclicBarrier(3);
		Thread serviceOneThread = new Thread(new ServiceOne(barrier));
		Thread serviceTwoThread = new Thread(new ServiceTwo(barrier));
		//Thread service3Thread = new Thread(new ServiceOne(barrier));
		
		System.out.println("Starting both the services at"+new Date());
		
		serviceOneThread.start();
		serviceTwoThread.start();
		//service3Thread.start();
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		}
		System.out.println("Ending both the services at"+new Date());
	}
	
	
}
