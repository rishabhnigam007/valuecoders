package Exception_Handling;

public class Multiple_Catch_Block 
{

	public static void main(String[] args) 
	{
		try 
		{
			int a=12;
			int b=0;
			int c=a/b;
			String s="asd";
			System.out.println(c);
			
			//if we commented first error then this is handle ny parent class
			// because here is number format exception
			int x=Integer.parseInt(s);
			System.out.println(x);
		}
		catch(NullPointerException e)
		{
			System.out.println("first catch block executed..");
			System.out.println(e);
		}
		catch(ArithmeticException e)
		{
			System.out.println("second catch block executed..");
			System.out.println(e);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("third catch block executed..");
			System.out.println(e);
		}
		// Parent class write in last if non of the catch block can handle
		// then this will definately handled
		catch(Exception e)
		{
			System.out.println("parent catch block executed..");
			System.out.println(e);
		}
		
	}

}