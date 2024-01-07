package mtl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//Threads are busy replying to each other
public class topic7_livelock {
	
	Lock lock1 = new ReentrantLock(true);
	Lock lock2 = new ReentrantLock(true);

	public void worker1() {
		while(true) {
			try {
				lock1.tryLock(50, TimeUnit.MILLISECONDS);
				System.out.println("Worker 1 acquires lock1");
			} catch (InterruptedException e) {}
			if(lock2.tryLock()) {
				System.out.println("Worker 1 acquires lock2");
				lock2.unlock();
				break;
			}
			else {
				System.out.println("Worker 1 not able to acquire lock2");
				continue;
			}
		}
		lock1.unlock();
		lock2.unlock();
	}

	public void worker2() {
		while(true) {
			try {
				lock2.tryLock(50, TimeUnit.MILLISECONDS);
				System.out.println("Worker 2 acquires lock2");
			} catch (InterruptedException e) {}
			if(lock1.tryLock()) {
				System.out.println("Worker 2 acquires lock1");
				lock1.unlock();
				break;
			}
			else {
				System.out.println("Worker 2 not able to acquire lock1");
				continue;
			}
		}
		lock1.unlock();
		lock2.unlock();
	

	}

	public static void main(String[] args) {
		topic7_livelock livelock = new topic7_livelock();
		new Thread(new Runnable() {

			@Override
			public void run() {
				livelock.worker1();
				
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				livelock.worker2();
				
			}
			
		}).start();
	}
}
