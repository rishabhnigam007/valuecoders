package multithreading;

public class Synchronized_Concurrency_Control 
{
	public static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException 
	{
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				for(int i=1;i<=1000;i++)
				{
					Synchronized_Concurrency_Control.counter++;
				}
				System.out.println("The loop in thread 1 is over");
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				for(int i=1;i<=1000;i++)
				{
					Synchronized_Concurrency_Control.counter++;
				}
				System.out.println("The loop in thread 2 is over");
			}
		});
		
		t1.start();
		t2.start();
		Thread.sleep(2000);
		System.out.println("The value of counter is : "+Synchronized_Concurrency_Control.counter);
	}
}