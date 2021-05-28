package multithreading.producer_consumer;

public class Consumer extends Thread 
{
	Company c;
	
	public Consumer(Company c) 
	{
		this.c=c;
	}
	
	 @Override
	public void run()
	{
		 try 
		 {
			this.c.consume_item();
		 } 
		 catch (Exception e1) 
		 {
			e1.printStackTrace();
		 }
		 try 
		 {
//			Thread.sleep(100);
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
	}
}