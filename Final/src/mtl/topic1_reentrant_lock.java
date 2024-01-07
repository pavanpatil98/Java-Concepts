package mtl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class topic1_reentrant_lock {
	private static final Lock lock = new ReentrantLock();
	public static void printNum(int n) {
		if(n==0)return;
		lock.lock();
		try {
			System.out.println(n);
			printNum(n-1);
		}
		finally {
			lock.unlock();
		}
	}
	public synchronized static void printNum1(int n) throws InterruptedException {
		if(n==0)return;
		System.out.println(n);
		Thread.sleep(1000);
		printNum1(n-1);
	}
	public static void main(String[] args) throws InterruptedException {
		printNum1(20);
	}
}
