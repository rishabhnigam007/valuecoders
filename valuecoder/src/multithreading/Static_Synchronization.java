package multithreading;

class Test
{
	synchronized static public void generate()
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

public class Static_Synchronization 
{
	public static void main(String[] args) 
	{
//		Test t1=new Test();
//		Test t2=new Test();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				long startTime=System.currentTimeMillis();
				for(int i=1;i<=5;i++)
				{
					Test.generate();
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
					Test.generate();
				}
				long endTime=System.currentTimeMillis();
				System.out.println("Time required for thread 2 was : "+(endTime-startTime));
			}
		}).start();
	}
}