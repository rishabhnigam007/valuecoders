package multithreading;


class Brackets
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

public class Synchronized_Method
{
	public static void main(String[] args) 
	{
		Brackets b=new Brackets();
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				for(int i=1;i<=5;i++)
				{
					b.generate();
				}
			}
		}).start();
	}
}