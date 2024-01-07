
//Lambdas can only use with interface having only one abstract method such interfaces 
//are also known as Funtional interfaces

interface Printer{
	void print();
}

class Cat implements Printer{
	public void print() {
		//System.out.println("Meow... Meow...");
	}
}

//with return type
interface RPrinter{
	String print(String s);
}
class Dog implements RPrinter{
	public String print(String s) {
		//System.out.println("Meow... Meow...");
		return s;
	}
}

public class Test {
	public static void printThing(Printer p) {
		p.print();
	}
	
	public static String printThing1(RPrinter rp,String s) {
		return rp.print(s);
	} 
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.print();//normal way
		
		//Means you don't have to create specific type to call print as per it.
		printThing(() -> {System.out.println("Meow... Meow...");});
		printThing(() -> {System.out.println("Beow... Beow...");});
		
		//if single exp then can remove curly braces
		printThing(() -> System.out.println("Ceow... Ceow..."));
		
		//Also you can assign it to variable
		Printer p = () -> System.out.println("Deow... Deow...");
		

		printThing(p);
		
		
		//Topic 2
		 Dog d = new Dog();
		 RPrinter rp = (s)->{
			 System.out.println("Bhooww.. Bhoww");
			 return s;
		 }; 
		 
		 String ans1 = printThing1((s)->{
			 return s;
		 },"Test");
		
		 //for just return
		 String ans2 = printThing1((s)->s+"Hello","tt");
		 
		 System.out.println(ans1+"---------"+ans2);
		
	}
}