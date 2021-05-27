package core_java;

public class Polymorphism
{
	void add(int a,int b)
	{
		System.out.println("Two Parameter Integer Sum : "+(a+b));
	}
	void add(int a,int b,int c)
	{
		System.out.println("Three Parameter Integer Sum : "+(a+b+c));
	}
	void add(float a,float b)
	{
		System.out.println("Two Parameter Float Sum : "+(a+b));
	}
	void add(double a,double b)
	{
		System.out.println("Two Parameter Double Sum : "+(a+b));
	}
	public static void main(String[] args) 
	{
		Polymorphism p=new Polymorphism();
		p.add(10, 20);
		p.add(100, 200, 300);
		p.add(10.5f, 20.8f);
		p.add(100000, 2000000, 30000000);
	}
}