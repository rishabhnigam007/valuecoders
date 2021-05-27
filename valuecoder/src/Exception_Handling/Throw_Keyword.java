package Exception_Handling;

public class Throw_Keyword 
{

	static void validate(int a)
	{
		if(a<18)
		{
			throw new ArithmeticException("Not Valid");
		}
		else
		{
			System.out.println("welcome to vote");
		}
	}
	
	public static void main(String[] args) 
	{
		// Throw keyword is used to explicitly throw an exception
		validate(7);
		System.out.println("confirmed operation");
	}

}