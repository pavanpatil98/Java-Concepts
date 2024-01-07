package mtl;

class daemonworker implements Runnable {
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Daemon is running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class normalworker implements Runnable {
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Worker is running...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class topic_daemon_worker_thread {

	public static void main(String[] args) throws InterruptedException {
		daemonworker d = new daemonworker();
		normalworker n = new normalworker();
		
		Thread t1 = new Thread(d);
		t1.setDaemon(true);
		Thread t2 = new Thread(n);
		
		t1.start();
		t2.start();
		t2.join();
		System.out.println("Fininshed Execution");
	}

}
