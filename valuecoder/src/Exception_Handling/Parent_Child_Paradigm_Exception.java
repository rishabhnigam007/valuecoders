package Exception_Handling;

class Parent
{
	void msg() throws Exception
	{
		System.out.println("Parent");
	}
}

public class Parent_Child_Paradigm_Exception extends Parent
{
	void msg() throws ArithmeticException
	{
		System.out.println("Child Exception");
	}

	public static void main(String[] args) 
	{
		Parent p=new Parent_Child_Paradigm_Exception();
		try {
		p.msg();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}


//	simple is that we can not assign parent class exception in child class
//	parent throws exception have higher level than child exception
//	if we declare throws Exception in child class then it is compile time error 
//	because we cant throws exception in parent class
//	parent would be same or higher priority level