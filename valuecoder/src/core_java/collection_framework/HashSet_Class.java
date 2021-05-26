package core_java.collection_framework;
import java.util.*;

public class HashSet_Class 
{
	public static void main(String[] args) 
	{
		
		// hashset store the element by using mechanism called hashing
		// contains unique elements only
		// non synchronized
		//doest not maintain insertion order beacuse element inserted on the basis of their hashcode
		// hashset is the best approach for search operation
		// initial capacity is 16 and load factor is 0.75
		
		HashSet<Integer> hs1=new HashSet<Integer>();
		hs1.add(111);
		hs1.add(222);
		hs1.add(33);
		
		System.out.println(hs1);
		Iterator<Integer> i=hs1.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		HashSet<Integer> hs2=new HashSet<Integer>();
		hs2.add(101);
		hs2.add(102);
		hs2.add(103);
		hs2.addAll(hs1);
		System.out.println(hs2);
		
	}
}