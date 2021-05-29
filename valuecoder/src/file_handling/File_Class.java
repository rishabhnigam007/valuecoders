package file_handling;

import java.io.File;
import java.io.IOException;

public class File_Class
{
	public static void main(String[] args)
	{
		// If we are not provide full Path like below then that is Relative Path
		//if folder not exist then it will give error
		File f=new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\File_Class.txt");
		
		// This is Relative Path
		// File f1=new File("src\\file_handling\\File_Class.txt");
		
		if(f.exists())
		{
			System.out.println("File is already exist !!");
		}
		else
		{
			try 
			{
				f.createNewFile();
				System.out.println("file successfully created !!");
			}
			catch (IOException e) 
			{
				System.out.println("file not created !!");
				e.printStackTrace();
			}
		}
	}
}