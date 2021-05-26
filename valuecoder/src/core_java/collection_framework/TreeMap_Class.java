package core_java.collection_framework;
import java.util.*;

public class TreeMap_Class 
{
	public static void main(String[] args) 
	{
		// TreeMap is implemented SortedMap interface and SortedMap extends Map interface
		// This is just like a dictionary in  python
		// Map containing Key Value Pair
		// TreeMap similar to TreeSet but In This key must be unique and value can't be null
		// does not contain duplicate keys
		// This is also generate hashcode
		// getKey() and getValue() method for getting keys and values
		
		//Map<key,value> map;
		TreeMap<Integer,String> map=new TreeMap<Integer, String>();
		map.put(1, "rishabh");
		map.put(2, "nigam");
		map.put(3, "kanpur");
		
		System.out.println(map);
		for(Map.Entry<Integer,String> m:map.entrySet())
		{
			System.out.println(m.getKey()+":"+m.getValue());
		}
		// print using stream and lambda function and for each loop
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		map.remove(2);
		System.out.println(map);
		
	}
}