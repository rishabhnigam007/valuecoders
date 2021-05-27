package Exception_Handling;

class InvalidAgeException extends Exception
{
	InvalidAgeException(String s)
	{
		super(s);
		System.out.println("Custom Exception called..");
	}
}

public class CustomException_Example 
{
	static void validate(int age) throws InvalidAgeException
	{
		if(age<18)
		{
			throw new InvalidAgeException("Age is Not Valid !!");
		}
		else
		{
			System.out.println("Welcome to vote");
		}
	}

	public static void main(String[] args) 
	{
		try
		{
			validate(17);
		}
		catch(Exception e) 
		{
			System.out.println("Exception occured : "+e);
		}
		System.out.println("Code working Fine with User Define Exception");
	}

}