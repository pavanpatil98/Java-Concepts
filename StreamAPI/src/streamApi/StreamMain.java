package streamApi;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
	public static void main(String[] args) {
		List<Integer> arr = List.of(1,2,3,4,5,6,7,8,9,10);
		Stream<Integer> stream = arr.stream();
		//getting even numbers
		List<Integer> result = stream.filter((i)->i%2==0).collect(Collectors.toList());
		System.out.println(result.toString()+"---------------");
		//getting numbers >= 5
		Stream<Integer> stream1 = arr.stream();
		List<Integer> result1 = stream1.filter((i)->i>=5).collect(Collectors.toList());
		System.out.println(result1.toString()+"--------------");
	}
}
