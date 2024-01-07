
public class PC {
	public int[] arr;
	public int idx = 0;
	public int fidx = 0;
	public PC(int size) {
		arr = new int[size];
		for(int i=0;i<arr.length;i++)arr[i]=-1;
	}
	public String print() {
		String ans = "";
		for(int ele:arr) {
			ans+=ele+" -> ";
		}
		return ans;
	}
	public void add(int ele) {
		if(idx==arr.length) {
			System.out.println("Queue is full");
			return;
		}
		else {
			
			arr[idx++]=ele;
			
		}
		System.out.println(print());
	}
	
	public void remove() {
		if(fidx==arr.length) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			arr[fidx]=-1;
			
			fidx++;
		}
		System.out.println(print());
		
	}
}
