package file_handling;

import java.io.FileInputStream;

public class FileInputStream_Class 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis=null;
		try 
		{
			fis=new FileInputStream("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileName_Getting_With_Paths.java");
			int i=0;
			while((i=fis.read()) != -1)
			{
				System.out.print((char)i);
			}
			System.out.println();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			fis.close();
		}
	}
}

/* Reading file with the help of FileInputStream Class */