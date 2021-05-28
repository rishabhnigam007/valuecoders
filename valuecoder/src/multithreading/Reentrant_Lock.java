package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant_Lock 
{
	static int counter=0;
	static Lock lock=new ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException 
	{
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				try 
				{
					lock.lock();
					for(int i=1;i<=1000;i++)
					{
						Reentrant_Lock.counter++;
					}
				}
				finally
				{
					lock.unlock();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				//when current thread completed then only it unlock
				try 
				{
					lock.lock();
					
					// if for loop give exception then it will not unlock
					// this is why we use try for exception
					// and finally for unlock if exception occur and it will always happen
					
					for(int i=1;i<=1000;i++)
					{
						Reentrant_Lock.counter++;
					}
				}
				finally
				{
					lock.unlock();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("The final value of counter is : "+Reentrant_Lock.counter);
		
	}
}