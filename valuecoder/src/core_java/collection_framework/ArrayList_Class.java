package core_java.collection_framework;
import java.util.*;

public class ArrayList_Class 
{
	public static void main(String[] args) 
	{
		List<String> list=new ArrayList<String>();
		list.add("xyz");
		list.add("pqr");
		// simple print like this --> [ xyz , pqr ]
		System.out.println(list);
		
		//use iterator for perfect array type print
		Iterator<String> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}