package core_java;
class SingletonClass 
{
	static SingletonClass sc=new SingletonClass();
	private SingletonClass()
	{
		
	}
	public static SingletonClass getInstance()
	{
		System.out.println("created instance !!");
		return sc;
	}
}
public class Test {

	public static void main(String[] args) 
	{
		SingletonClass sc=SingletonClass.getInstance();
	}
}