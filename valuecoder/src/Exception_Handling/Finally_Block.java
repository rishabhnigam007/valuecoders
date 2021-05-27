package Exception_Handling;

public class Finally_Block
{
	public static void main(String[] args) 
	{
		try 
		{
			int a=12;
			int b=0;
			int c=a/b;
			System.out.println(c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("this finally block always executed ..");
		}
		
	}
}