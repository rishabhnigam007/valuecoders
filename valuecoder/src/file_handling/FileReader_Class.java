package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Class 
{
	public static void main(String[] args) throws IOException 
	{
		File f= new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileWriter_Class.txt");
		
		FileReader fr=null;
		
		try 
		{
			fr=new FileReader(f);
			int data=fr.read();
			while(data != -1)
			{
				System.out.print((char)data);
				data=fr.read();
			}
			System.out.println();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File not exists");
			System.out.println(e.getMessage());
		}
		finally
		{
			fr.close();
		}
	}
}