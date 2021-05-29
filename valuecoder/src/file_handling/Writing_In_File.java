package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Writing_In_File 
{
	public static void main(String[] args)
	{
		File f= new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\File_Class.txt");
		PrintWriter pw=null;
		if(f.exists())
		{
			try 
			{
				pw = new PrintWriter(f);
				pw.println("I am writing on this file \nwhich is already created !!");
				System.out.println("Writing operation done because file is already created !!");
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("File not exist !!");
			}
			finally
			{
				// whenever we are not closing this printwriter class object
				// it won't write anything in the file
				pw.close();
			}
		}
		else
		{
			try 
			{
				f.createNewFile();
				System.out.println("file successfully created !!");
				pw=new PrintWriter(f);
				pw.println("I am creating and writing on this file !!");
				System.out.println("Creating and writing done !!");
				
			}
			catch (IOException e) 
			{
				System.err.println("Error creation in file!!");
			}		
			finally
			{
				// whenever we are not closing this printwriter class object
				// it won't write anything in the file
				pw.close();
			}
		}
	}
}