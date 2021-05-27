package Concurrent_Package;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JavaConcurrencyException 
{
	public static void main(String[] args) 
	{
		List<String> l=new CopyOnWriteArrayList<String>();
		l.add("hii");
		l.add("hello");
		l.add("whatsup");
		l.add("hey");
		l.add("hii");
		for(String s:l)
		{
			if(s.equals("hello"))
			{
				//this line generate exception
				//because in iterator u can't modified list
				//because in this time two thread run simultaneously
				l.remove(s);
			}
		}
		for(String s1:l)
			System.out.println(s1);
	}
}

/* only three method for handle this exception :
(i)CopyOnWriteArrayList
(ii)CopyOnWriteArraySet
(i)ConcurrentHashMap
(1).use import java.util.concurrent.CopyOnWriteArrayList for ArrayList exception handle.
(2).use import java.util.concurrent.CopyOnWriteArraySet for ArraySet exception handle
(3).use import java.util.concurrent.ConcurrentHashMap for HashMap exception handle
*/
