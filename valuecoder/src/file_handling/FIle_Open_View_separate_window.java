package file_handling;

import java.awt.Desktop;
import java.io.File;

public class FIle_Open_View_separate_window 
{
	public static void main(String[] args)
	{
		File f=new File("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileName_Getting_With_Paths.java");
		
		if(!Desktop.isDesktopSupported())
		{
			System.out.println("This is not supported your desktop !!");
		}
		else
		{
			Desktop desktop=Desktop.getDesktop();
			try 
			{
				if(f.exists())
				{
					desktop.open(f);
					System.out.println("File is open in View !!");
				}
				else
				{
					System.out.println("File not exists");
				}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
}