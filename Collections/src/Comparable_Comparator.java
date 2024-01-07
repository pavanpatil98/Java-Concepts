import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Record implements Comparable<Record>{
	int id;
	int qid;
	public Record(int id,int qid) {
		this.id = id;
		this.qid = qid;
	}
	@Override
	public int compareTo(Record o) {
		return this.qid-o.qid;
	}
}
public class Comparable_Comparator {
	//Comparable Natural Ordering & Comparator Total Ordering
	//If both are there comparator ordering takes effect
	
	
	
	//This is natural ordering with comparable interface
	//For custom class we can change compareTo to change ordering but for wrapper classes Integer
	//& other we cannot modify compareTo implementation so to overcome it we came up with comparator
	
	
	public static void main(String[] args) {
		//=== ************************************Comparable -> Natural Ordering
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(40);
		for(int ele : pq) {
			System.out.println("------------"+ele+"------------------");
		}
		System.out.println("=====================================================");
		List<Record> l = new ArrayList<>();
		PriorityQueue<Record> pr = new PriorityQueue<>();
		pr.add(new Record(10,100));
		pr.add(new Record(20,90));
		pr.add(new Record(30,80));
		while(!pr.isEmpty()) {
			Record r = pr.poll();
			System.out.println(r.qid);
		}
		
		//This is natural ordering with comparable interface
		//For custom class we can change compareTo to change ordering but for wrapper classes Integer
		//& other we cannot modify compareTo implementation so to overcome it we came up with comparator
		
		//=== ************************************Comparator -> Total Ordering
		
		//Providing custom way default is ascending we provided descending
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->b-a);
		pq1.add(21);
		pq1.add(22);
		pq1.add(23);
		pq1.add(24);
		for(int ele : pq1) {
			System.out.println("------------"+ele+"------------------");
		}
		System.out.println("=====================================================");
		
		//In compare we have provided qid sorting order now in comaprator I will provide id sorting order
		PriorityQueue<Record> pr1 = new PriorityQueue<>((a,b)->a.id-b.id);
		pr1.add(new Record(10,100));
		pr1.add(new Record(20,90));
		pr1.add(new Record(30,80));
		while(!pr1.isEmpty()) {
			Record r = pr1.poll();
			System.out.println(r.qid);
		}
	}
}
