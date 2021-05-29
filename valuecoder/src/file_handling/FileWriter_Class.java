package file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriter_Class 
{
	public static void main(String[] args) 
	{
		File f= new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileWriter_Class.txt");
				
		Scanner sc=null;
		
		try
		{
			if(f.createNewFile())
			{
				System.out.println("File is created !!");
			}
			else
			{
				System.out.println("File already Exists !!");
			}
			FileWriter fw=new FileWriter(f);
			sc=new Scanner(System.in);
			System.out.println("Enter content to the file !!");
			
			String s=sc.nextLine();
			fw.write(s);
			System.out.println();
			System.out.println("Successfully Write in a file !!");
						
			fw.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			sc.close();
		}
	}
}

/*
	Use File.createNewFile() method to create new file.
	This method returns a boolean value 
	True if the file is created successfully.
	False if the file already exists or the operation failed for some reason
*/
