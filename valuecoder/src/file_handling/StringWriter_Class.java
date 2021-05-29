package file_handling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StringWriter_Class 
{
	public static void main(String[] args) throws Exception
	{
		char ar[]=new char[512];
		StringWriter writer=new StringWriter();
		FileInputStream input =null;
		BufferedReader buffer =null;
		
		input =new FileInputStream("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\FileOutputStream_Class.txt");
		buffer =new BufferedReader(new InputStreamReader(input, "UTF-8"));
		int x;
		while( (x=buffer.read(ar)) != -1)
		{
			// it write all data from file FileOutputStream_Class.txt
			writer.write(ar, 0, x);
		}
		// and here print this using toString() method
		System.out.println(writer.toString());
		writer.close();
		buffer.close();
	}
}