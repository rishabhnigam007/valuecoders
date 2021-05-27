package Exception_Handling;

public class Arithmatic_Exception
{
	public static void main(String[] args) 
	{
		try 
		{
			int a=13;
			int b=0;
			int c=a/b;
			System.out.println(c);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}