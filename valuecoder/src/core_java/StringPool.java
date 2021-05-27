package core_java;

public class StringPool
{
	public static void main(String[] args) 
	{
		String s1="cat";
		String s2="cat";
		String s3="dog";
		String s4=new String("cat");
		System.out.println(s1==s2); //true
		System.out.println(s1==s3); //false
		//this will different because it will not go string pool
		// it will create separate space
		System.out.println(s1==s4); //false
	}
}