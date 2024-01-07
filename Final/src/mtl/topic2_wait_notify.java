package mtl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Process {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Entering inside producer thread");
			this.wait();
			System.out.println("Exiting from producer thread");
		}

	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			System.out.println("Entering inside consumer thread");
			this.notify();
			// System.out.println("Exiting from producer thread");
		}
	}
}
class ProcessQueue {
	public Queue<Integer> queue;
	public int capacity;
	public ProcessQueue(int capacity) {
		this.queue = new LinkedList<>();
		this.capacity = capacity;
	}
	public int value = 1;

	public int getNum() {
		Random random = new Random();
		int randomNumber = random.nextInt();
		return randomNumber%100;
	}
	public void produce(int ele) throws InterruptedException {
		synchronized (queue) {
			if(queue.size() == capacity) {
				System.out.println("Queue is full");
				queue.wait();
			}
			else {
				// int ele = getNum();
				System.out.println("Adding element " + ele);
				queue.add(ele);
				capacity++;
				queue.notify();
			}
		}

	}

	public void consume() throws InterruptedException {
		synchronized (queue) {
			if(queue.size() == 0) {
				System.out.println("Queue is empty");
				queue.wait();
			}
			else {
				int ele = queue.poll();
				System.out.println("Removing element " + ele);
				capacity--;
				queue.notify();
			}
			
		}
	}
	
	public void produceEnhanced(int ele) throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == capacity) {
				System.out.println("Queue is full");
				queue.wait();
			}

			// int ele = getNum();
			System.out.println("Adding element " + ele);
			queue.add(ele);
			capacity++;
			queue.notify();

		}

	}

	public void consumeEnhanced() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == 0) {
				System.out.println("Queue is empty");
				queue.wait();
			}

			int ele = queue.poll();
			System.out.println("Removing element " + ele);
			capacity--;
			queue.notify();

		}
	}
	public void produceEnhanced1() throws InterruptedException {
		synchronized (queue) {
			while(true) {
				if (queue.size() == capacity) {
					System.out.println("Queue is full.. waiting");
					queue.wait();
				}
				else {
					System.out.println("Adding element " + value);
					queue.add(value);
					queue.notify();
					value++;
				}
				Thread.sleep(100);
			}
		}

	}

	public void consumeEnhanced1() throws InterruptedException {
		synchronized (queue) {
			while(true) {
				if (queue.size() == 0) {
					value = 0;
					System.out.println("Queue is empty.. waiting");
					queue.wait();
				}
				else {
					int ele = queue.poll();
					System.out.println("Removing element " + ele);
					queue.notify();
				}
				Thread.sleep(100);
			}
		}
	}
}

public class topic2_wait_notify {
	public static void main(String[] args) {
		Process p = new Process();
		ProcessQueue pq = new ProcessQueue(10);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					for(int i=1;i<=100;i++) {
						pq.produceEnhanced1();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					for(int i=1;i<=100;i++) {
						pq.consumeEnhanced();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//t1.start();
		//t2.start();
		
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					pq.produceEnhanced1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t4 = new Thread(new Runnable() {
			public void run() {
				try {
					pq.consumeEnhanced1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t4.start();
		t3.start();
		
	}
}
