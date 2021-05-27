package Exception_Handling;

public class ArrayIndexOutOfBound_Exception 
{
	public static void main(String[] args) 
	{
		int ar[]=new int[5];
		
		try 
		{
			// size is 5 and we assign a value in 6 position 
			ar[5]=10;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
//			e.printStackTrace();
			System.out.println(e);
		}
		// exception is parent class of all the exception
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}