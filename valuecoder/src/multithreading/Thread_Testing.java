package multithreading;

class UserThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("This is user define thread");
	}
}

public class Thread_Testing 
{
	public static void main(String[] args) 
	{
		System.out.println("Program started ...");
		int x=56+34;
		System.out.println("sum is : "+x);
		
		//Thread..
		Thread t=Thread.currentThread();
		String tname=t.getName();
		System.out.println("Current Thread name is : "+tname);
		
		//set name
		t.setName("My_Thread");
		System.out.println(t.getName());
		
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Thread Id : "+t.getId());
		
		// going to start user thread
		
		UserThread ut=new UserThread();
		ut.start();
		
		System.out.println("Program ended ...");
	}
}