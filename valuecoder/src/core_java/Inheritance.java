package core_java;


class A
{
	A()
	{
		// Parent class constructor called first
		// whenever we called child class it will called parent class constructor first
		
		System.out.println("Class A Called !!");
	}
	
	void fun()
	{
		System.out.println("Class A : Fun function");
	}
}

class B extends A
{
	B()
	{
		// after parent class constructor called.
		System.out.println("Class B Called !!");
	}
	@Override
	void fun()
	{
		// it will called parent class function first.
		super.fun();
		System.out.println("Class B : Fun function");
	}
}

public class Inheritance
{
	public static void main(String[] args) 
	{
		B obj=new B();
		obj.fun();
	}
}

/* 
Output : Class A Called !!
		 Class B Called !!
		 Class A : Fun function
		 Class B : Fun function
 */