package mtl;

public class topic1_synchronization {
	public static int counter = 0;
	
	//solution
	//using synchronized keyword
	public static synchronized void increment1() {
		counter++;
	}
	public static synchronized void increment2() {
		counter++;
	}
	
	//using synchronized block
	public static void increment3() {
		synchronized(topic1_synchronization.class) {
			counter++;
		}
	}
	public static void increment4() {
		synchronized(topic1_synchronization.class) {
			counter++;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=10000;i++)
				//counter++;
				//increment1();//synchronized keyword way
				increment3();//synchronized block way
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=10000;i++)
				//counter++;
				//increment2();//synchronized keyword way
				increment3();//synchronized block way
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter);
	}
}
