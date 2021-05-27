package java_8_features;


interface Vehicle
{
	// This is java 8 feature that we can declare a method with body also
	// permission to define concrete method in interface in java 8
	default void print()
	{
		System.out.println("I have a vehicle!");
	}
	// also we can define static method with java 8 
	static void blowHorn()
	{
		System.out.println("Blowing horn!!");
	}
}

public class Default_Method_Interface implements Vehicle
{
	public static void main(String[] args) 
	{
		Vehicle v=new Default_Method_Interface();
		v.print();
		Vehicle.blowHorn();
	}
}