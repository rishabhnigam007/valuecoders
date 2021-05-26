package core_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Try_With_Resource 
{
	public static void main(String[] args) 
	{
		File f=new File("d:\\cover letter format.txt");
		// or  find place that file which is not exits then exception will automatically handle
				
		try(BufferedReader br=new BufferedReader(new FileReader(f)))
		{
			String line;
			while( (line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Can't find file "+f.toString());
		}
		catch (IOException e) 
		{
			System.out.println("Unable to read file "+f.toString());
		}
	}
}