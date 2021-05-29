package file_handling;

import java.io.File;

public class Fetching_All_File_In_Directory 
{
	public static void main(String[] args) 
	{
		File directory=new File("C:\\users\\rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling");
		File files[]=directory.listFiles();
		int i=1;
		for(File file:files)
		{
			System.out.println(i+" File Name : "+file.getName());
			i++;
		}
	}
}

/* Fetching all files in the given directory or file location */

/*
  
output :
	1 File Name : Console_Input.java
	2 File Name : Directory_Creation.java
	3 File Name : document
	4 File Name : Fetching_All_File_In_Directory.java
	5 File Name : FileInputStream_Class.java
	6 File Name : FileName_Getting_With_Paths.java
	7 File Name : FileOutputStream_Class.java
	8 File Name : FileOutputStream_Class.txt
	9 File Name : FileReader_Class.java
	10 File Name : FileWriter_Class.java
	11 File Name : FileWriter_Class.txt
	12 File Name : File_Class.java
	13 File Name : File_Class.txt
	14 File Name : FIle_Open_View_separate_window.java
	15 File Name : Get_File_Extension.java
	16 File Name : OpenFile.java
	17 File Name : ReadFromScanner.java
	18 File Name : StringReader_Class.java
	19 File Name : StringWriter_Class.java
	20 File Name : Writing_In_File.java

*/