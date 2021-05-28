package multithreading;

class Bracketss
{
	// if we use synchronized keyword then only one thread going to be executed at a time
	// A monitor lock would be applied for particular object
	// lock is derived by object
	// so it may cause falsity
	// if one thread executed then it is good except one it take some irregularity
	synchronized public void generate()
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
		System.out.println();
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