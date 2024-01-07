package mtl;

import java.util.concurrent.atomic.AtomicInteger;

public class topic8_Atomic {
	public int counter;
	public static AtomicInteger AtomicCounter = new AtomicInteger(0);
	public void increment() {
		for(int i=0;i<10000;i++) {
			AtomicCounter.getAndIncrement();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		topic8_Atomic test = new topic8_Atomic();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				test.increment();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				test.increment();
			}
		});
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(AtomicCounter.get()+"---------------");
	
	}
}
