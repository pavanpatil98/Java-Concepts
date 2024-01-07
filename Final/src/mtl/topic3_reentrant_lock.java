package mtl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class topic3_reentrant_lock {
	private static int counter = 0;
	private static Lock lock = new ReentrantLock();
	public static void increment() {
		lock.lock();
		//Best Practice to use try finaaly so even if exception occurs lock is released
		try {
			for (int i = 1; i <= 10000; i++) {
				counter++;
			}
		}
		finally {
			lock.unlock();
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter);
	}
}
