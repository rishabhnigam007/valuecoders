package file_handling;

import java.io.FileOutputStream;
import java.util.Scanner;

public class FileOutputStream_Class 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		try 
		{
			FileOutputStream fout=new FileOutputStream("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileOutputStream_Class.txt");
			sc=new Scanner(System.in);
			System.out.println("Enter content to file : ");
			String s=sc.nextLine();
			// Stream classes basically write on bytes
			//convert string to byte using getByte() method then only it write
			fout.write(s.getBytes());
			System.out.println();
			System.out.println("Successfully write !!");
			fout.close();	
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			sc.close();
		}
	}
}