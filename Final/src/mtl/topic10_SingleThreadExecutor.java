package mtl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	public int id;
	public Task(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println("Thread id is "+id+" with details"+Thread.currentThread());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class topic10_SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++) {
			ex.execute(new Task(i));
		}
		//must to closed the executors
	}
}
