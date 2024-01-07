package mtl;

class runnable1 implements Runnable {
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Test the data");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class runnable2 implements Runnable{
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Test the values");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class thread1 extends Thread {
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Test the thread 1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class thread2 extends Thread{
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("Test the thread 2");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



public class topic_creation {
	public static void main(String args[]) {
		//Using runnable interface
		runnable1 r1 = new runnable1();
		runnable2 r2 = new runnable2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		//t1.start();
		//t2.start();
		
		//Using thread class
		
		thread1 th1 = new thread1();
		thread2 th2 = new thread2();
		
		th1.start();
		th2.start();
		
		//joining of threads
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished with main thread");
		
		
		
	}
}
