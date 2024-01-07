package mtl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class test{
	Semaphore s;
	
	public test() {
		this.s = new Semaphore(3,true);
	}
	
	public void download() {
		try {
			s.acquire();
			downloadData();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		finally {
			s.release();
		}
	}
	public void downloadData() throws InterruptedException {
		System.out.println("Downloading data from the web....");
		Thread.sleep(5000);
	}
}
public class topic9_Semaphore {
	public static void main(String[] args) {
		test t = new test();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<=12;i++) {
			es.execute(new Runnable() {
				public void run() {
					t.download();
				}
			});
		}
		
	}
}
