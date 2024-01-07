package Threads;

public class Thread1 extends Thread {
	public String name;
	public Thread1(String name) {
		super(name);
	}
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread());
			System.out.println("Hello "+i);
		}
	}
}
