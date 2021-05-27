package core_java;

public class StringToCharacterArray 
{
	public static void main(String[] args) 
	{
		String s="this is string to char conversion";
		char c[]=s.toCharArray();
		for(char ch :c )
		{
			System.out.print(ch+".");
		}
		System.out.println();
		System.out.println("String From 8 Index to 14 Index : "+s.substring(8,14));
	}
}