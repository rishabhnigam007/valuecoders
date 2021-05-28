package multithreading.producer_consumer;

public class Producer extends Thread  
{
	
	Company c;
	
	Producer(Company c)
	{
		this.c=c;
	}
	
	@Override
	public void run()
	{
		int i=1;
		while(true)
		{
			try
			{
				this.c.produce_item(i);
				i++;
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			try 
			{
//				Thread.sleep(100);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}