package mtl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class topic6_deadlocks{
	public Lock lock1 = new ReentrantLock(true);
	public Lock lock2 = new ReentrantLock(true);
	
	public void test1(){
		synchronized(lock1) {
			System.out.println("Acquired lock1 by test1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			synchronized(lock2) {
				System.out.println("Acquired lock2 by test1");
			}
		}
	}
	
	public void test2(){
		synchronized(lock2) {
			System.out.println("Acquired lock2 by test2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			synchronized(lock1) {
				System.out.println("Acquired lock1 by test2");
			}
		}
	}
	
	public static void main(String[] args) {
		topic6_deadlocks td = new topic6_deadlocks();
		new Thread(new Runnable() {

			@Override
			public void run() {
				td.test1();
				
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				td.test2();
				
			}
			
		}).start();
	}
	
}
