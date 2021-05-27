package Exception_Handling;

public class NullPointer_Exception 
{

	public static void main(String[] args) 
	{
		try 
		{
			String s=null;
		
		// whenever we get a length of this string it will produce exception
		// null pointer exception
		// because null have no size so exception occur
			System.out.println(s.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
