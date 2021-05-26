package core_java;

public class Instance_And_Local_Variable 
{
	// instance variable
	int a=20;
	
	public int display()
	{
		// Local variable
		int a=30;
		return a;
	}
	public static void main(String[] args) 
	{
		Instance_And_Local_Variable obj=new Instance_And_Local_Variable();
		System.out.println(obj.display());
	}
}