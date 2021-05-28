/* 
 * wait()
 * notify()
 * notifyAll()
 * All these method is applicable on object level  
 *  */
// if we are not using synchronized block then it will error 

// link : https://www.youtube.com/watch?v=2z218xjvw1M  
// by durgasoft sir
package multithreading;

class ThreadB extends Thread
{
	// join() method not used because notify() method do this
	
	int total=0;
	public void run()
	{
		synchronized (this)
		{
			System.out.println("Child thread start execution");
			for(int i=0;i<=100;i++)
			{
				total=total+i;
			}
			System.out.println("execution end...");
			this.notify();
		}
		
	}
}

public class Thread_All_Method 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ThreadB b=new ThreadB();
		b.start(); 
		synchronized (b)
		{
			System.out.println("Main thread calling wait() method");
			// called
			b.wait();
			// whenever this called then child thread is started execution
			System.out.println("Main thread got notification call");
			System.out.println("Total is : "+b.total);
		}
	}
}