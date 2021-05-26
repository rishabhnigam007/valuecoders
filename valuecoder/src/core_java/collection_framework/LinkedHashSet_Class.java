package core_java.collection_framework;
import java.util.*;

public class LinkedHashSet_Class 
{
	public static void main(String[] args) 
	{
		
		//Linkedhashset same as linkedlist but it does not contain duplicate element
		// it maintain insertion order
		//linkedhashset inherit hashset class and implement set interface
		// LinkedHashSet class is a hastable 
		
		LinkedHashSet<Integer> ll=new LinkedHashSet<Integer>();
		ll.add(11);
		ll.add(12);
		ll.add(71);
		ll.add(50);
		ll.add(10);
		
		// also use addAll() method for nested linkedlist
		
		// clear() method is for clear linkedlist but set is still exists
		
		//but we use remaove() method then delete is affectedin set
		
		// isEmpty() return true if the linkedlist is empty
		
		System.out.println(ll);
		
		// Size() method for getting size
		System.out.println("Size is : "+ll.size());
		
		Iterator<Integer> i=ll.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		// we can convert this is object of type array so we can call using loop like array we call
		// here I use toArray() method for making list to array
		
		Object a[]=ll.toArray();
		
		System.out.println();
		for(int j=0;j<a.length;j++)
		{
			System.out.print(a[j]+" ");
		}		
		System.out.println();
		System.out.println("Hashcode : "+ll.hashCode());
	}
}