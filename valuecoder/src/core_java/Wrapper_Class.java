package core_java;

public class Wrapper_Class 
{
	public static void main(String[] args) 
	{
		// primitive data type or Primitive Class
		int s=2;
		// non primitive data type or Wrapper Class
		Integer i;
		// process to change datatype primitive to wrapper is known as autoboxing
		// Autoboxing
		i=(Integer)s;
		System.out.println(i);
		
		Character c='r';
		// Unboxing
		char a=(char)c;
		System.out.println(a);
	}
}