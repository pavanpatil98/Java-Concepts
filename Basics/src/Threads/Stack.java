package Threads;

public class Stack extends Thread{
	int[] arr;
	int top;
	int size;
	public Stack(int size) {
		arr = new int[size];
		top = -1;
	}
	public  void push(int ele) {
			synchronized(this){
			if(top==arr.length) {
				System.out.println("Stack overflow");
				return;
			}
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
			System.out.println("Added element " + ele);
			arr[++top] = ele;
			}
	}
	
	public synchronized int pop() {
		if(top<0) {
			System.out.println("Stack underflow");
			return -1;
		}
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			
		}
		System.out.println("Remove element " + arr[top]);
		return arr[top--];
	}
	public int peek() {
		if(top<0) {
			System.out.println("Stack underflow");
			return -1;
		}
		if(top>arr.length) {
			System.out.println("Stack overflow");
			return -1;
		}
		return arr[top];
	}
}
