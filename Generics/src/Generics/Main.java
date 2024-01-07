package Generics;

import java.util.ArrayList;
import java.util.List;

//===================Topic 1.0 Generics (Type Safety Weapon)========================
class IntegerPrinter{
	Integer val;
	public IntegerPrinter(Integer val) {
		this.val = val;
	}
	public  void print() {
		System.out.println("Value is "+this.val);
	} 
}
class DoublePrinter{
	Double val;
	public DoublePrinter(Double val) {
		this.val = val;
	}
	public  void print() {
		System.out.println("Value is "+this.val);
	} 
}
class StringPrinter{
	String val;
	public StringPrinter(String val) {
		this.val = val;
	}
	public  void print() {
		System.out.println("Value is "+this.val);
	} 
}
//===================Generics========================
class Printer<T>{
	T val;
	public Printer(T val) {
		this.val = val;
	}
	public  void print() {
		System.out.println("Value is "+this.val);
	} 
}
//===================Topic 2.0 Bounded Generics  using extends========================
class Animal{
	String name;
	public void setName(String name) {this.name = name;}
	public String getName(){return this.name;}
}
class Cat extends Animal{
	String distance;
	public void setDistance(String distance) {this.distance = distance;}
	public String getDistance(){return this.distance;}
}
class Dog extends Animal{
	String distance;
	public void setDistance(String distance) {this.distance = distance;}
	public String getDistance(){return this.distance;}
}
class AnimalPrinter<T extends Animal>{
	T val;
	public AnimalPrinter(T val) {
		this.val = val;
	}
	public  void print() {
		System.out.println("Value is "+this.val.getName());
	} 
}


public class Main {
	//===============Topic 3 generic Methods
	public static <F,L> void call(F fname, L lname) {
		System.out.println(fname+"----------------"+lname);
	}
	//with return value
	public static <F,L> F callReturn(F fname, L lname) {
		System.out.println(fname+"----------------"+lname);
		return fname;
	}
	
	
	//===================Topic 4 Using wildcards========================
	//If you think you can pass List<Object> instead of List<?> u are wrong as 
	//Object is Parent of all other object but List<Object> is not parent of List<OtherObjects>
	public static void printList(List<?> list) {
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		//*************************Topic 1
		//Issue we have to create separate types to handle printing based on datatype
		IntegerPrinter ip = new IntegerPrinter(10);
		ip.print();
		DoublePrinter dp = new DoublePrinter(10.00);
		dp.print();
		StringPrinter sp = new StringPrinter("Pavan");
		sp.print();
		
		//solution use generics 
		Printer<Integer> pi = new Printer<>(10);
		pi.print();
		Printer<Double> pd = new Printer<>(10.00);
		pd.print();
		Printer<String> ps = new Printer<>("Pavan");
		ps.print();
		//same can be achieve with taking object type but type safety issue is big blocker
		
		
		////****************************Topic 2(Bounded Generics)
		Cat c = new Cat();
		c.setName("Mani");
		Dog d = new Dog();
		d.setName("Rambo");
		
		AnimalPrinter<Cat> catP = new AnimalPrinter<>(c);
		catP.print();
		AnimalPrinter<Dog> dogP = new AnimalPrinter<>(d);
		dogP.print();
		
		
		//********************************Topic 3 Generics Method
		call("Pavan","Patil");
		call(100,200);
		call(100.0,200.0);
		
		String fname = callReturn("Pavan","Patil");
		
		//********************************Topic 4 WildCard with Collections
		List<Integer> li = new ArrayList<>();
		li.add(10);
		li.add(20);
		printList(li);
		
		List<String> strli = new ArrayList<>();
		strli.add("Pavan");
		strli.add("Patil");
		printList(strli);
		
			
	}

}
