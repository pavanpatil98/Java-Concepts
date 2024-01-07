package mtl;

class threadPriority1 extends Thread{
	public void run() {
		for(int i=0;i<10;i++)
		System.out.println("This is high priority thread");
	}
}
class threadPriority2 extends Thread{
	public void run() {
		for(int i=0;i<10;i++)
		System.out.println("This is low priority thread");
	}
}
public class topic_thread_priority {
	public static void main(String[] args) {
		threadPriority1 t1 = new threadPriority1();
		threadPriority2 t2 = new threadPriority2();
		t1.setPriority(10);
		t1.start();
		t2.start();
		
		
	}
}
