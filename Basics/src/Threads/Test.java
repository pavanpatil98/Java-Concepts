package Threads;

public class Test{

	public static void main(String[] args) throws InterruptedException {
		Stack st = new Stack(5);
		Thread t1 = new Thread(()->{
			for(int i=1;i<=5;i++) {
				st.push(i);
			}
		
		},"thread1");
		Thread t2 = new Thread(()->{
			for(int i=1;i<=5;i++) {
				st.pop();
			}
		
		},"thread2");
		t1.start();
		//t2.sleep(1000);
		t2.start();
		
	}
	/*public static void main(String[] args) {
		System.out.println("Starting the main thread");
		Thread1 t1 = new Thread1("Child1 Thread");
		//Thread t2 = new Thread(new Thread2(),"Child2 Thread");
		Thread t2 = new Thread(()->{
			for(int i=1;i<=5;i++) {
				System.out.println(Thread.currentThread());
				System.out.println("Hello "+i);
			}
		
		},"thread2");
		
		//t1.setName("child");
		//t1.setDaemon(true);
		t1.start();
		t2.start();
		System.out.println("Exiting the main thread");
		
	}*/
}
