package java_8_features;


//	This is also known as Functional interface
interface Sayable
{
	// No parameter function
	public String says();
}

interface Addition
{
	int add(int a,int b);
}

interface Square
{
	void mul(int a,int b);
}

public class Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		// Lambda expression provide implementation of functional interface
		// it is fast and act like anonymous class
		// Syntax : (argument-list) -> {body}
		
//		Java lambda expression is consisted of three components.
//
//		1) Argument-list: It can be empty or non-empty as well.
//
//		2) Arrow-token: It is used to link arguments-list and body of expression.
//
//		3) Body: It contains expressions and statements for lambda expression.
		
		Sayable s = () -> { 
			System.out.println("No parameter function called ");
			return "I have nothing to say.";
			};
		System.out.println(s.says());	
		
		// Define implementation (a+b) then use
		Addition add= (a,b) -> (a+b);
		System.out.println("Two parameter function called ");
		System.out.println("Addition is : "+add.add(10, 20));
		
		Square square=(int x,int y)->System.out.println(x*y);
		System.out.println("Void parameter function called ");
		square.mul(2,2);
		
	}
}