package file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Directory_Creation 
{
	public static void main(String[] args) 
	{
		File f= new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\document");
		
		Scanner sc=new Scanner(System.in);
		
		if(f.mkdir())
		{
			System.out.println("Directory is Created !!");
		}
		else
		{
			System.out.println("Directory already existed !!");
		}
		System.out.println("You want to create a file in this directory !!");
		System.out.println(" 1 . Create File : ");
		System.out.println(" 2 . Exit : ");
		int option = sc.nextInt();
		switch (option) 
		{
			case 1:
				System.out.println("Enter a file name : ");
				String name=sc.next();
				File f1= new File("C:\\Users\\Rishabh\\git\\valuecoders\\valuecoder\\src\\file_handling\\document\\"+name+".txt");
				try 
				{
					f1.createNewFile();
					System.out.println("File is created !!");
					FileWriter fw=new FileWriter(f1);
					System.out.println("Enter the content in file : ");
					// here buffer is created so need to clear this buffer
					sc.nextLine(); // for clearing buffer
					String content =sc.nextLine();
					fw.write(content);
					System.out.println("Content write successfully !!");
					fw.close();
				}
				catch (IOException e) 
				{
					System.out.println(e.getMessage());
				}
				finally
				{
					sc.close();
				}					
				break;
					
			case 2:
					
				System.out.println("Thank you for using !!");
				System.exit(0);
					
				break;						

			default:
				System.out.println("Wrong input typed !!");
				System.out.println("Bye bye !!");
				break;
		}
	}
}