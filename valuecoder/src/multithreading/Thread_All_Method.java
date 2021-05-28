package multithreading;

class A1 extends Thread
{
	int t=0;
	public void run()
	{
		// it will refer the current object
		synchronized (this) 
		{
			for(int i=0;i<=10;i++)
			{
				t=t+i;
			}
			this.notify();
		}
	}
}


public class Thread_All_Method 
{
	public static void main(String[] args) throws InterruptedException 
	{
		A1 a=new A1();
		a.start();
		synchronized (a)
		{
			System.out.println("Main Thread");
			a.wait();
			System.out.println("Main Thread got notified");
			System.out.println(a.t);
			
		}
	}
}