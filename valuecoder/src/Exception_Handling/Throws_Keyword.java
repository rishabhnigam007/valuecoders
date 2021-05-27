package Exception_Handling;

import java.io.IOException;

class GenerateException
{
	// if throws were not present here then only exception throw and handle here
	void fun() throws IOException
	{
		throw new IOException("Device error");
	}
}

public class Throws_Keyword 
{
	public static void main(String[] args) 
	{
		try
		{
			GenerateException ge=new GenerateException();
			ge.fun();
		}
		catch(Exception e)
		{
			System.out.println("Exception Handled");
		}
		System.out.println("Code Working Fine...");
	}

}