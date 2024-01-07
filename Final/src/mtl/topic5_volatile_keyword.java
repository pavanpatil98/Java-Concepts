package mtl;

class testVolatile implements Runnable{
	//Effect we cannot see but there are some reasons why we can see differences
	//1. Main thread & worker both in same cpu core reading from same cache
	//2.Even we do not declared istreminated volatile it is stored on main memory
	public volatile boolean isTerminated;
	public testVolatile(){
		this.isTerminated = false;
	}
	public void setTerminated(boolean terminated) {
		this.isTerminated = terminated;
	}
	public void run() {
		while(!isTerminated) {
			System.out.println("Thread is running...");
		}
	}
}
public class topic5_volatile_keyword {
	public static void main(String[] args) throws InterruptedException {
		testVolatile tv = new testVolatile();
		Thread t = new Thread(tv);
		t.start();
		t.sleep(1000);
		tv.setTerminated(true);
		t.join();
		System.out.println("Thread terminated");
	}
	
}
