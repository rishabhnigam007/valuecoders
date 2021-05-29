package file_handling;

import java.io.File;

public class Get_File_Extension 
{
	private static String getFileExtension(File file)
	{
		String extension=null;
		try
		{
			if(file != null && file.exists())
			{
				String name=file.getName();
				extension=name.substring(name.lastIndexOf("."));
			}
			else
			{
				System.out.println("File not exits !!");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return extension;
	}
	
	public static void main(String[] args) 
	{
		String extension=getFileExtension(new File("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileName_Getting_With_Paths.java"));
		System.out.println("File Extension : "+extension);
	}
}