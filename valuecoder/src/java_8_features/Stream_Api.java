package java_8_features;

import java.util.*;
import java.util.stream.Stream;

public class Stream_Api 
{
	public static void main(String[] args) 
	{
		List<Integer> value=Arrays.asList(1,2,3,4,5,6);

		Stream<String> s=Stream.of("Geeks","fOr","GEEKSQUIZ","GeeksforGeeks");

		// new method for print using forEach() method
		System.out.print("List Element :");
		value.forEach(i->System.out.print(i+" "));

		System.out.println();
		System.out.print("Using Lambda Expression divisible by 2 is :");
		value.stream().filter(i->i%2==0).forEach(i->System.out.print(i+" "));

		System.out.println();
		System.out.print("multiplied by 2 list element :");
		value.stream().map(i->i*2).forEach(i->System.out.print(i+" "));

		System.out.println();
		s.filter(str->str.endsWith("s")).forEach(str->System.out.println(str));
	}
}