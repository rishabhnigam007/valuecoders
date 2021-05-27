package Concurrent_Package;

public class Concurrency_Example extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Thread Starting...");
	}
	public static void main(String[] args) 
	{
		Concurrency_Example ce1=new Concurrency_Example();
		Concurrency_Example ce2=new Concurrency_Example();
		Concurrency_Example ce3=new Concurrency_Example();
		Concurrency_Example ce4=new Concurrency_Example();
		ce1.start();
		ce2.start();
		ce3.start();
		ce4.start();
		
	}
}