import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		/*Thread t1 = new Thread(new Search("test1.txt"));
		Thread t2 = new Thread(new Search("test2.txt"));
		Thread t3 = new Thread(new Search("test3.txt"));
		Thread t4 = new Thread(new Search("test4.txt"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();*/
		
		ExecutorService exec = Executors.newFixedThreadPool(2); 
		exec.execute(new Search("test1.txt"));
		exec.execute(new Search("test2.txt"));
		exec.execute(new Search("test3.txt"));
		exec.execute(new Search("test4.txt"));
		System.out.println("String occured --> "+IOUtils.getOccurences());
	}
}

class Search implements Runnable{
	
	String filename;
	
	public Search(String filename) {
		this.filename = filename;
	}
	
	public void run() {
		IOUtils.fileSearch(filename);
	}
}