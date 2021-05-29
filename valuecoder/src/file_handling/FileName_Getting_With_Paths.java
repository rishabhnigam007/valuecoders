package file_handling;

import java.io.File;

public class FileName_Getting_With_Paths 
{
	public static void main(String[] args) throws Exception
	{
		File f=new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\fileWriter_Class.java");
		System.out.println("Path : "+f.getPath());
		System.out.println("Absolute Path : "+f.getAbsolutePath());
		System.out.println("Canonical Path : "+f.getCanonicalPath());
	}
}

/*

output : 
	Path : C:\Users\Rishabh\git\valuecoders\valuecoder\src\file_handling\fileWriter_Class.java
	Absolute Path : C:\Users\Rishabh\git\valuecoders\valuecoder\src\file_handling\fileWriter_Class.java
	Canonical Path : C:\Users\Rishabh\git\valuecoders\valuecoder\src\file_handling\FileWriter_Class.java
	
*/

// Canonical path give exact file name path see the difference in file java Get Path and Asolute Path (fileWriter_Class.java) Small f letter
// are almost same but canonical give real name which is Capital F of file name FileWriter_Class.java