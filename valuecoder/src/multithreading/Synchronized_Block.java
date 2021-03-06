package multithreading;

class Bracketss
{
	// if we use synchronized keyword then only one thread going to be executed at a time
	// A monitor lock would be applied for particular object
	// lock is derived by object
	// so it may cause falsity
	// if one thread executed then it is good except one it take some irregularity
	public void generate()
	{
		// There are two type of lock in multithreading
				// 1. object level 
				// 2. class level
		
		// all thread going to be executed one by one
		// synchronized lock is for object level
		
		// This is class level lock and 		
		synchronized(Bracketss.class)
		{
	
		for(int i=1;i<=10;i++)
		{
			try 
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(i<=5)
			{
				System.out.print("[");
			}
			else
			{
				System.out.print("]");
			}
		}
		
		}
		System.out.println();
		
		for(int j=0;j<=10;j++)
		{
			try 
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

public class Synchronized_Block 
{
	public static void main(String[] args) 
	{
		Bracketss b1=new Bracketss();
		Bracketss b2=new Bracketss();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				long startTime=System.currentTimeMillis();
				for(int i=1;i<=5;i++)
				{
					b1.generate();
				}
				long endTime=System.currentTimeMillis();
				System.out.println("Time required for thread 1 was : "+(endTime-startTime));
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				long startTime=System.currentTimeMillis();
				for(int i=1;i<=5;i++)
				{
					b2.generate();
				}
				long endTime=System.currentTimeMillis();
				System.out.println("Time required for thread 2 was : "+(endTime-startTime));
			}
		}).start();
	}
}