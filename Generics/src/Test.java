import java.util.ArrayList;

class CustomType<T,S>{
	T t;
	S s;
	public T getValue() {
		return this.t;
	}
	public void setvalue(T t) {
		this.t = t;
	}
	
	public S getSValue() {
		return this.s;
	}
	public void setSvalue(S s) {
		this.s = s;
	}
}
public class Test {

	public static void main(String[] args) {
		CustomType<Integer,ArrayList<Integer>> ct = new CustomType<>();
		ct.setvalue(100);
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		ct.setSvalue(arr);
		System.out.println(ct.getValue()+"-----------------"+ct.getSValue().toString());

	}

}
