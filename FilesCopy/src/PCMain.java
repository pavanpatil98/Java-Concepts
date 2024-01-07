

class test implements Runnable{

	@Override
	public void run() {
		
		
	}
	
}
public class PCMain {
	public static void main(String[] args) {
		PC pc = new PC(5);
		for(int i=0;i<5;i++)pc.add(i+1);
		for(int i=0;i<5;i++)pc.remove();
		
	}
	
}
