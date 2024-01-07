import java.util.Iterator;

class MyList<T> implements Iterable<T>{
	T[] items;
	int size = 0;
	public MyList() {
		items = (T[]) new Object[100];
		size = 0;
	}
	public void add(T t) {
		items[size++]= t;
	}
	public int size() {
		return size;
	}
	public T getItemsAtIndex(int index) {
		return items[index];
	}
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}
	
	private class MyIterator<T> implements Iterator<T>{
		MyList<T> list;
		int index;
		
		public MyIterator(MyList<T> ml) {
			this.list = ml;
		}
		@Override
		public boolean hasNext() {
			
			return index < list.size();
		}

		@Override
		public T next() {
			return list.items[index++];
		}
		
	}
	
}
public class Test1 {

	public static void main(String[] args) {
		MyList<Integer> pavan = new MyList<>();
		pavan.add(10);
		pavan.add(20);
		pavan.add(30);
		pavan.add(40);
		
		for(int ele :pavan) {
			System.out.println(ele);
		}

	}

}