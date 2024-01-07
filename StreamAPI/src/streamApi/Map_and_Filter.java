package streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map_and_Filter {
	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,4,5,6);
		//1
		//filter to select some of the elements based on boolean condition known as predicate
		List<Integer> filterList = list.stream().filter(i->i%2==0 && i>2).collect(Collectors.toList());
		System.out.println(filterList.toString());
		filterList.stream().forEach(ele->System.out.println(ele));
		
		//2
		//map to perform some operation on each & every element
		List<Integer> mapList = list.stream().map(i->i*=2).collect(Collectors.toList());
		System.out.println(mapList.toString());
		mapList.stream().forEach(System.out::println); //Alternate way to print the values
		
		//3
		Integer minVal = mapList.stream().min((a,b)-> a.compareTo(b)).get();
		System.out.println(minVal);
		
		//4
		Integer maxVal = mapList.stream().max((a,b)-> a.compareTo(b)).get();
		System.out.println(maxVal);
		
		//5
		List<Integer> ans = list.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
		System.out.println(ans.toString());
		
	}
}
