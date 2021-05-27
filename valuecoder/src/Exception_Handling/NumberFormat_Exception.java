package Exception_Handling;

public class NumberFormat_Exception 
{

	public static void main(String[] args) 
	{
		//if string s has a number then it will parse to integer and no error
		String n="123";
		int number=Integer.parseInt(n);
		System.out.println(number);
		
		try 
		{
			String s="Rishabh";
			int x=Integer.parseInt(s);
			System.out.println(x);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
