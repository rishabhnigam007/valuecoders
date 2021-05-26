package core_java.collection_framework;

import java.util.*;

public class LinkedHashMap_Class 
{
	public static void main(String[] args) 
	{
		// HashMap is implemented Map interface
		// This is just like a dictionary in Python
		// Java LinkedHashMap may have one null key and multiple null values.
		// getKey() and getValue() method for getting keys and values
		//Map<key,value> 
			
		LinkedHashMap<Integer,String> map=new LinkedHashMap<Integer, String>();
		
		map.put(1, "ki ki kiran");
		map.put(2, "rahul");
		map.put(3, "joble");
		
		System.out.println(map);
		for(Map.Entry<Integer,String> m:map.entrySet())
		{
			System.out.println(m.getKey()+":"+m.getValue());
		}
			
		map.remove(2);
		System.out.println(map);
			
		map.put(4, "kar");
		System.out.println(map);
				
		map.replace(1, "karan");
		System.out.println(map);
		
		// only keys printed
		System.out.println("Keys : "+map.keySet());
		
		// only values printed
		System.out.println("Values : "+map.values());
	}
}