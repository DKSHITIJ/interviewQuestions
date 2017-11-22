package com.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApplicationStartupUtil 
{
	private static List<BaseHealthChecker> _services;
	private static CountDownLatch _latch;
	
	private ApplicationStartupUtil()
	{
	}
	
	private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
	
	public static ApplicationStartupUtil getInstance()
	{
		return INSTANCE;
	}
	
	public static boolean checkExternalServices() throws Exception
	{
		_latch = new CountDownLatch(3);
		_services = new ArrayList<BaseHealthChecker>();
		_services.add(new NetworkHealthChecker(_latch));
		_services.add(new CacheHealthChecker(_latch));
		_services.add(new DatabaseHealthChecker(_latch));
		
		ExecutorService executor = Executors.newFixedThreadPool(_services.size());
		
		/*ExecutorCompletionService executorcompletion = new ExecutorCompletionService(
				executor);
		List<Future> listFuture = new ArrayList<Future>();*/
		for(final BaseHealthChecker v : _services) 
		{
			executor.execute(v);
			//listFuture.add( executorcompletion.submit(v));
			//executor.submit(v);
		}
		
		_latch.await();
		
		for(final BaseHealthChecker v : _services) 
		{
			if( ! v.isServiceUp())
			{
				return false;
			}
		}
		
		/*for(Future f : listFuture) {
			Object o = f.get();
		}
		for (int i = 0; i < _services.size(); i++) {
			Object o1 = executorcompletion.take().get();
		}*/
		return true;
	}
	
	
}
