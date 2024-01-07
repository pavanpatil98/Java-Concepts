package pratice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class QueuePC{
	public Queue<Integer> queue;
	public int capacity;
	public Semaphore semaphore;
	public QueuePC(int capacity) {
		this.queue = new LinkedList<>();
		this.capacity = capacity;
		this.semaphore = new Semaphore(capacity);
	}
	
	public void add(int ele) throws InterruptedException {
		semaphore.acquire();
		synchronized (queue) {
			while(queue.size() == capacity) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Adding element "+ele+" in the queue");
			queue.add(ele);
			if(capacity-1==queue.size())queue.notify();
			queue.notify();
			
		}
		semaphore.release();
	}
	
	public void remove() throws InterruptedException {
		semaphore.acquire();
		synchronized (queue) {
			while (queue.size() == 0) {
				System.out.println("Empty call");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			int ele = queue.poll();
			System.out.println("Removing element " + ele + " in the queue");
			if(queue.size()== 1)
			queue.notify();
			
		}
		semaphore.release();
	}
}

public class MainThread {
	public static void main(String[] args) throws Exception {
		QueuePC qpc = new QueuePC(10);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=100;i++) {
					try {
						qpc.add(i);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=100;i++) {
					try {
						qpc.remove();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
