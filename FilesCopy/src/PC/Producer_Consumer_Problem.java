package PC;

import java.util.LinkedList;
import java.util.Queue;

class TQueue{
	
	Queue<Integer> q = new LinkedList<>();
	int capacity;
	public TQueue(int capacity) {
		this.capacity = capacity;
	}
	public  void add(int element) {
		synchronized (q) {
			while (q.size() == capacity) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Queue is full");
				// return;
			}

			System.out.println("Adding " + element + " to the queue");
			q.add(element);
			q.notifyAll();
		}
		//print();
	}
	public synchronized void remove(){
		synchronized (q) {
			while (q.size() == 0) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("Queue is empty");
				// return;
			}

			int ele = q.peek();
			System.out.println("Removing " + ele + " to the queue");
			q.remove();
			q.notifyAll();
			}
		
	}
	
	public void print() {
		for(int ele:q) {
			System.out.println(ele+" ");
		}
	}
}

public class Producer_Consumer_Problem {
	public static void main(String[] args) throws InterruptedException {
		TQueue q = new TQueue(10);
		Thread t1 = new Thread(new Exc(q));
		Thread t2 = new Thread(new Exc1(q));
		//t2.start();
		t1.start();
		t2.start();
		
		
		/*for(int i=1;i<=20;i++) {
			q.add(i);
		}
		for(int i=1;i<=20;i++) {
			q.remove();
		}*/
		
	}
}

class Exc implements Runnable{

	public TQueue q;
	public Exc(TQueue q) {
		this.q = q;
	}
	public void run() {
		for(int i=1;i<=20;i++) {
			q.add(i);
		}
	}
}
class Exc1 implements Runnable{

	public TQueue q;
	public Exc1(TQueue q) {
		this.q = q;
	}
	public void run() {
		for(int i=1;i<=20;i++) {
			q.remove();
		}
	}
}
