package multithreading;

public class Volatile_keyword
{
	// if we use volatile keyword in variable then 
	// this variable is not collected by cache memory
	// its free from cache and update its value
	// volatile is only for variable 
	
	volatile public static int flag=0;
	
	public static void main(String[] args) 
	{
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				while(true)
				{
					if(flag==0)
					{
						System.out.println("Running : "+flag);
					}
					else
					{
						break;
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				try 
				{
					Thread.sleep(01);
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				Volatile_keyword.flag=1;
				System.out.println("Flag value is updated : "+flag);
			}
		}).start();
	}
}