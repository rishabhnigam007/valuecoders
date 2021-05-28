package multithreading;

class MyCounter extends Thread
{
	private int threadNo;
	public MyCounter(int threadNo)
	{
		this.threadNo=threadNo;
	}
	
	@Override
	public void run() 
	{
		countMe();
	}
	
	public void countMe()
	{
		for(int i=1;i<10;i++)
		{
			try 
			{
				sleep(500);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println("The value of i is :"+i+" and the threadNo is : "+threadNo);
		}
	}
}

public class Thread_Class
{
	public static void main(String[] args) throws InterruptedException
	{
		MyCounter counter1=new MyCounter(1);
		MyCounter counter2=new MyCounter(2);
		
		long startTime=System.currentTimeMillis();
		counter1.start();
		System.out.println("****************************");
		counter2.start();
		Thread.sleep(4500);
		long endTime=System.currentTimeMillis();
		System.out.println("Total time required is to process : "+(endTime-startTime));
	}
}