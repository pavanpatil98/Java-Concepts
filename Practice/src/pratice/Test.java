package pratice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



class TQueue{
	Queue<Integer> queue = new LinkedList<>();
	int capacity = 100;
	int counter;
	public void add(int element) {
		synchronized (queue) {
			while (queue.size() == capacity) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Adding element "+element);
			queue.add(element);
			queue.notifyAll();
		}
	}

	
	public void remove() {
		synchronized (queue) {

			while (queue.size() == 0) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int element = queue.poll();
			System.out.println("Removing element "+element);
			queue.notifyAll();
			counter++;
		}
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public int totalProcessed() {
		return counter;
	}
}

class Producer implements Runnable{
	private TQueue queue;
	private int sidx;
	private int lidx;
	public Producer(TQueue queue,int sidx,int lidx) {
		this.queue = queue;
		this.sidx = sidx;
		this.lidx = lidx;
	}
	public void run() {
		for(int i=sidx;i<=lidx;i++) {
			queue.add(i);
		}
	}
}

class Consumer implements Runnable{
	private TQueue queue;
	public Consumer(TQueue queue) {
		this.queue = queue;
	}
	public void run() {
		while(queue.getSize()>0) {
			queue.remove();
		}
	}
}
public class Test {
	public static void main(String[] args) {
		TQueue tq = new TQueue();
		Thread p1 = new Thread(new Producer(tq,1,10000));
		Thread p2 = new Thread(new Producer(tq,10001,20000));
		//Thread r1 = new Thread(new Consumer(tq));
		
		p1.start();
		p2.start();
		//r1.start();
		
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(10);
		ex.scheduleAtFixedRate(new Consumer(tq), 1000, 1, TimeUnit.MILLISECONDS);
		
	}
}
