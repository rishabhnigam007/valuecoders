package core_java.collection_framework;
import java.util.*;

public class HashMap_Class 
{
	public static void main(String[] args) 
	{
		// HashMap is implemented Map interface
		// This is just like a dictionary in python
		// Map containing Key Value Pair and maintains NO order
		// Java HashMap may have one null key and multiple null values.
		// getKey() and getValue() method for getting keys and values
		// no duplicate keys in hashmap it will replace it
		//Map<key,value> 
		
		HashMap<Integer,String> map=new HashMap<Integer, String>();
			map.put(1, "hello");
			map.put(2, "hii");
			map.put(3, "whatsup");
				
			System.out.println(map);
			for(Map.Entry<Integer,String> m:map.entrySet())
			{
				System.out.println(m.getKey()+":"+m.getValue());
			}
			
			map.remove(2);
			System.out.println(map);
			
			map.put(4, "instagram");
			System.out.println(map);
			
			map.replace(1, "facebook");
			System.out.println(map);
	}
}