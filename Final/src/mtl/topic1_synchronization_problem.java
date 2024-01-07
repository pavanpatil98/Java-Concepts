package mtl;

public class topic1_synchronization_problem {
	public static int counter1 = 0;
	public static int counter2 = 0;

	//Here problem is inc1 & inc2 are independent methods with independent variables but
	//as we are synchronizing over the static method so single lock of class is is used due
	//to which we can execute any of the method at a time to overcome it we can make used of custom locks
	public static  void increment1() {
		synchronized(topic1_synchronization_problem.class) {
			counter1++;
		}
	}

	public static void increment2() {
		synchronized(topic1_synchronization_problem.class) {
			counter2++;
		}
	}
	//solution
	
	public static Object lockobj1 = new Object();
	public static Object lockobj2 = new Object();
	
	public static void increment3() {
		synchronized(lockobj1) {
			counter1++;
		}
	}

	public static void increment4() {
		synchronized(lockobj2) {
			counter2++;
		}
	}
	

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 10000; i++)
					increment3();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 10000; i++)
					increment4();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter1+"---------------"+counter2);
	}

}
