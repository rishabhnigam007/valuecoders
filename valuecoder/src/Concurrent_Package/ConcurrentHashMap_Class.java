package Concurrent_Package;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_Class 
{

	public static void main(String[] args) 
	{
		// All operation are thread safe
		// Retrieval operations do not entail locking
		// COncurrentHashMap extends AbstractMap<k,v> and implements ConcurrentMap<k,v> and Serializable interface
				
		// initial capacity bydefault is 16 but we can assign as we want in ConcurrentHashMap<>(size)
		// fill ratio or load factor  is 0.75
		ConcurrentHashMap<String, Integer> chm=new ConcurrentHashMap<String, Integer>();
		chm.put("A", 15);
		chm.put("B", 10);
		chm.put("C", 16);
		chm.put("D", 15);
		chm.put("E", 15);
		System.out.println("Mappings are : "+chm);
		// .containsValue() method for checking wheather value is present or not
		System.out.println("Is 10 present? : "+chm.containsValue(10));
		
		//compute(key ,(key,value) -> operation on value) method
		chm.compute("E", (key,val) ->val+100);
		
		// if key not present then it will give error
		// (1) NullPointerException
		// (2) IllegalStateException
		// (3) RuntimeException
		System.out.println();
		System.out.println("New Map is : \nAfter adding 100 to its value on key 'E' : "+chm.toString());
		
		// if not want error then use 
		// computeIfAbsent(key,key->100+200) it will update value to corresponding key
		
		chm.computeIfAbsent("F", F -> 10);
		System.out.println();
		System.out.println("New Map is : \nAfter new Key and its value : "+chm.toString());
		// if key present then it will return its value
		System.out.println();
		System.out.println("value : "+chm.get("B"));
		// if key not present then it will return null
		System.out.println("value : "+chm.get("G"));
		
		// Traversing
		Iterator<Entry<String, Integer>> it=chm.entrySet().iterator();
		while(it.hasNext())
		{
			ConcurrentHashMap.Entry<String, Integer> entry = it.next();
			System.out.println("Key : "+entry.getKey()+"  Value : "+entry.getValue());
		}
		
		System.out.println("Size : "+chm.size());
		// or 
		System.out.println("Size : "+chm.mappingCount());
		
		// doubt in merge() method
		
		
		// print using for each loop
		System.out.println("Using ForEach Loop -->");
		chm.forEach((k,v)->System.out.printf("key : %s , value : %s %n",k,v));
	}

}