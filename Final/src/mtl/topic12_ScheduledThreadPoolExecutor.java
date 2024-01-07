package mtl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class T implements Runnable{
	public int id;
	public T() {
		
	}
	public void run() {
		System.out.println("Reading & Updating the data...");
	
	}
}
public class topic12_ScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
		ex.scheduleAtFixedRate(new T(), 1000, 1000, TimeUnit.MILLISECONDS);
		
		//must to closed the executors

	}

}
