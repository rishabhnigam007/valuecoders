package Exception_Handling;

public class Finalize_Example 
{

	public static void main(String[] args) 
	{
		Finalize_Example f1=new Finalize_Example();
		Finalize_Example f2=new Finalize_Example();
		
		f1=null;
		f2=null;
		 
		// null object is garbage collected explicitly
		// whenever we call gc() method
		// otherwise it will automatically garbage collected implicitly
		System.gc();
	
	}

}
