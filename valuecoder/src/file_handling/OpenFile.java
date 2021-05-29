package file_handling;

import java.awt.Desktop;
import java.util.*;
import java.io.*;
class OpenFile
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=null;
		BufferedReader br=null;
		FileInputStream fis=null;
		
		
		try 
		{
			File f=new File("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileName_Getting_With_Paths.java");
			System.out.println("This is using Scanner class : --->");
			sc=new Scanner(f);
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			System.out.println();
			System.out.println("This is using BufferedReader class : --->");
			br=new BufferedReader(new FileReader(f));
			int r=0;
			while((r=br.read())!=-1)
			{
				System.out.print((char)r);
			}
			System.out.println();
			System.out.println();
			System.out.println("This is using FileInputStream class : --->");
			fis=new FileInputStream(f);
			while((r=fis.read())!=-1)
				System.out.print((char)r);			
			/*  same as FileReader class */
			System.out.println();
			System.out.println("This is for desktop class : --->");
			if(!Desktop.isDesktopSupported())
			//check if Desktop is supported by Platform or not  
			{  
				System.out.println("Not Supported");  
				return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(f.exists())//checks file exists or not  
			desktop.open(f); 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			sc.close();
			br.close();
			fis.close();
		}
	}
}