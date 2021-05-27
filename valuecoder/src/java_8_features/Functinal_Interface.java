package java_8_features;

// this is functional interface
//interface Activity
//{
//	void act(String play);
//}

@FunctionalInterface
interface Funny
{
	// Functional interface can have only one abstract method 
	// they can have any number of default and static method
	
	// Abstract Method
	void act(String play);
	
	default void acting(String s)
	{
		System.out.println("Hero : "+s);
	}
	static void dancing(String s)
	{
		System.out.println("Great Dancer : "+s);
	}
}

public class Functinal_Interface implements Funny
{
	@Override
	public void act(String play) 
	{
		System.out.println("Perfect Act By !! : "+play);
	}
	public static void main(String[] args) 
	{
		Functinal_Interface fi=new Functinal_Interface();
		fi.act("Amir khan");
		fi.acting("Ranveer Singh");
		Funny.dancing("Madhuri Dixit");
	}
}