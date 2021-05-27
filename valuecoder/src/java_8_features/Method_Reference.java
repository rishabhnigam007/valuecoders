package java_8_features;

import java.util.ArrayList;
import java.util.List;

public class Method_Reference 
{
	public static void main(String[] args) 
	{
		
		// Here :: is used for method reference
		
		List<Integer> l=new ArrayList<Integer>();
		
		l.add(12);
		l.add(13);
		l.add(15);
		l.add(11);
		
		System.out.println(l);
		
		// using for each loop
		l.forEach(System.out::println);
		
	}
}