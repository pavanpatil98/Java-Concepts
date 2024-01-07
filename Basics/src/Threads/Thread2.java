package Threads;

public class Thread2 implements Runnable {
	public String name;
	
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread());
			System.out.println("Hello "+i);
		}
	}
}
