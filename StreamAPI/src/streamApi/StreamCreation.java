package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		//way 1 
		Stream<Object> emptystream = Stream.empty();
		
		//way 2
		String[] names = {"Pavan","Harshal","Test","Prateek","Anmol"};
		Stream<String> streamString = Stream.of(names);
		streamString.forEach(ele->System.out.println(ele));
		
		//way 3
		Stream<Object> streamBuilder = Stream.builder().build();
		
		//way4
		IntStream istream = Arrays.stream(new int[]{1,2,3,4});
		istream.forEach(ele->System.out.println(ele));
		
		//way5
		List<Integer> list = List.of(10,20,30,40);
		list.stream().forEach(ele->System.out.println(ele));
	}

}
