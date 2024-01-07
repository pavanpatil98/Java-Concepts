package pratice;

import java.util.LinkedList;
import java.util.Queue;

class TestQ{
	Queue<Integer> que = new LinkedList<>();
	int capacity;
	public TestQ(int cap) {
		this.capacity = cap;
	}
	public int getSize() {
		return que.size();
	}
	public void add(int ele) throws InterruptedException {
		synchronized(que){
			while(getSize()==capacity) {
				que.wait();
			}
			System.out.println("Added element "+ ele);
			que.add(ele);
			que.notifyAll();
		}
	}
	public void remove() throws InterruptedException {
		synchronized(que){
			while(getSize() == 0) {
				que.wait();
			}
			int ele = que.remove();
			System.out.println("Removed element "+ele );
			que.notifyAll();
		}
	}
}
public class Testr {
	public static void main(String[] args) {
		TestQ tq = new TestQ(5);
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 20; i++) {
				try {
					tq.add(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 20; i++) {
				try {
					tq.remove();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}
}
