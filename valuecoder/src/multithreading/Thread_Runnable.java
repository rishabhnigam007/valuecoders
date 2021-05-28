package multithreading;

import java.util.Random;

class MyCount implements Runnable
{
	private int threadNo;
	
	public MyCount(int threadNo)
	{
		this.threadNo=threadNo;
	}
	
	@Override
	public void run() 
	{
		Random r=new  Random();
		
		for(int i=0;i<10;i++)
		{
			try 
			{
				Thread.sleep(r.nextInt(500));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println("The value of i is : "+i+" and value of threadNo is : "+threadNo);
		}
	}
	
}

public class Thread_Runnable
{
	public static void main(String[] args) 
	{
//		Thread t1=new Thread(new MyCount(1));
//		Thread t2=new Thread(new MyCount(2));
//		t1.start();
//		t2.start();
		
		// it just like a anonymous object
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() 
			{
				for(int i=0;i<10;i++)
				{
					try 
					{
						Thread.sleep(500);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
			
		});
		thread.start();
	}
}