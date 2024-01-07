package Threads;

public class PC_Problem {
	public static int cnt = 0;
	public static int cnt1 = 0;
	public static int cnt2 = 60;
	public static void main(String[] args) throws InterruptedException {
		BQueue queue = new BQueue(5);
		
		Thread t1 = new Thread(()->{
			while(true) {
				if(cnt==50)break;
				queue.add(cnt++);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"thread1");
		Thread t3 = new Thread(()->{
			while(true) {
				if(cnt2==100)break;
				queue.add(cnt2++);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"thread1");
		Thread t2 = new Thread(()->{
			while(true) {
				if(cnt1==50)break;
				queue.remove();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"thread2");
		t1.start();
		//t2.sleep(1000);
		t2.start();
		t3.start();
		
	}
}
