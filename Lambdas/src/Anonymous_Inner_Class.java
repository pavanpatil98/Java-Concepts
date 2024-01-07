
//Creates a subclass with new implementation for give method
class Animal{
	public void print() {
		System.out.println("This is animal for you!");
	}
}
public class Anonymous_Inner_Class {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.print();
		
		//the unamed subclass is created of animal class where we can have own impelementation
		Animal animal1 = new Animal(){
			public void print() {
				System.out.print("This is the inner animal for you!");
		}};
		
		animal1.print();
		
				
	}
}
