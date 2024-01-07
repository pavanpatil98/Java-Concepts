package mtl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class UseRELock{
	
	Lock lock = new ReentrantLock();
	//You cannot use wait & notify on lock object
	Condition condition = lock.newCondition();
	
	public void produce() throws InterruptedException {
		try {
			lock.lock();
			System.out.println("Entering inside produce method");
			condition.await();//like wait
			System.out.println("Exiting from produce method");
		}
		finally {
			lock.unlock();
		}
	}
	
	public void consume() {
		try {
			lock.lock();
			System.out.println("Entering inside consume method");
			condition.signal(); //like notify
		}
		finally {
			lock.unlock();
		}
	
	}
}

public class topic4_wait_notify_using_reentrant_lock {
	public static void main(String[] args) {
		UseRELock re = new UseRELock();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					re.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				re.consume();
			}
		});
		
		t1.start();
		t2.start();
	}
}
