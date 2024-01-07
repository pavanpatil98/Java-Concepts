package mtl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test implements Runnable{
	public int id;
	public Test(int id) {
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
public class topic11_FixedThreadExecutor {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(5);
		for(int i=0;i<15;i++) {
			ex.execute(new Test(i));
		}
		//must to closed the executors
	}

}
