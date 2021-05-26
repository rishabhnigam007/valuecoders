package core_java.collection_framework;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList_Class 
{
	public static void main(String[] args) 
	{
		// In collection framework LinkedList is uses a Doubly Linked List Internally
		// Insertion order is maintain but nor synchronized
		LinkedList<String> ll=new LinkedList<String>();
		ll.add("abc");
		ll.add("pqr");
		ll.add("xyz");
		ll.add("olx");
		ll.addFirst("rishabh");
		ll.addLast("nigam");
		ll.add(1, "is a good boy ");
		System.out.println(ll);
		System.out.println("Tradition print : ");
		Iterator<String> itr=ll.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}