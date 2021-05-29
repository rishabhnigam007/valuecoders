package file_handling;

public class Console_Input 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Your Name : ");
		String name=System.console().readLine();
		System.out.println("Welcome "+name);
	}
}

/* I dont know why this is not running */