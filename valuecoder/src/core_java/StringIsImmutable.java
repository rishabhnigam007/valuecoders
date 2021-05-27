package core_java;

public class StringIsImmutable 
{
	public static void main(String[] args) 
	{
		String s1="hii";
		String s2=s1;
		String s3="hello";
		System.out.println(s1); //hii
		System.out.println(s2); //hii
		System.out.println(s3); //hello
		System.out.println(s1==s2); //true
		s2="hey";
		System.out.println(s1==s2); //false
		System.out.println(s1==s3); //false
		System.out.println(s2==s3); //false
		System.out.println(s1); //hii
		System.out.println(s2); //hey
		System.out.println(s3); //hello
		
	}
}