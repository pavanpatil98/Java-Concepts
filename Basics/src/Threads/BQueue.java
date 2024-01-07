package Threads;

import java.util.LinkedList;
import java.util.Queue;

public class BQueue {
	private Queue<Integer> queue;
	private int capacity;
	
	public BQueue(int cap) {
		this.queue = new LinkedList<>();
		this.capacity = cap;
	}
	
	public void add(int ele) {
		synchronized(queue) {
			while(queue.size()==capacity) {
				System.out.println("Capacity has been hit");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("Queue is full");
				return;
			}
			System.out.println("Adding element --->"+ ele);
			queue.add(ele);
			queue.notifyAll();
		}
	}
	public void remove() {
		synchronized(queue) {
			while(queue.size()==0) {
				System.out.println("Queue is Empty");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int ele = queue.poll();
			System.out.println("Removing element --->"+ ele);
			queue.notifyAll();
		}
	}
}
