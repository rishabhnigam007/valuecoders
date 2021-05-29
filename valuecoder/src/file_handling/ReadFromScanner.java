package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromScanner 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		
//		File f=new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\Directory_Creation.java");
//		Scanner sc=new Scanner(f);
		
		//or 
		
		Scanner sc=new Scanner(new File("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileWriter_Class.java"));
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}