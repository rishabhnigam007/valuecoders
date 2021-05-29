package file_handling;

import java.io.StringReader;

public class StringReader_Class 
{
	public static void main(String[] args) throws Exception
	{
		 String s = "Hello Java!! \nThe Programming Language";  
		 StringReader reader = new StringReader(s);  
		 int k=0;  
		 while( (k=reader.read()) != -1)
	     {  
			 System.out.print((char)k);  
		 }
	}
}