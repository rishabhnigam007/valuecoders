package core_java;

abstract class Person
{
	abstract void eat();
}

public class Abstract_Class 
{
	public static void main(String[] args) 
	{
		Person p = new Person() 
					{
						void eat()
						{
							System.out.println("eating !!");
						}
					};
			p.eat();
	}
}