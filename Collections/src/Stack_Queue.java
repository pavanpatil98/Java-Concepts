import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Queue {
	public static void main(String[] args) {
		
		//FIFO or LILO Queue
		Queue<Integer> queue = new LinkedList<>();
		//offer is better than add
		
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
		
		while(queue.size()>0) {
			System.out.println(queue.poll());
		}
		
		//FILO or LIFO
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		while(stack.size()>0) {
			System.out.println("---------------------------");
			System.out.println(stack.pop());
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addFirst(10);
		dq.addFirst(20);
		dq.addLast(40);
		dq.addLast(30);
		
		while(dq.size()>0) {
			int ele = dq.removeLast();
			System.out.println("--------------"+ele+"----------------");
		}
	}
}
