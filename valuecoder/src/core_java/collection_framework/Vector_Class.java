package core_java.collection_framework;
import java.util.*;

public class Vector_Class 
{
	public static void main(String[] args) 
	{
		//vector is dynamic array similar to array list
		// it is synchronized
		// has more method that are not part of the collection framework
		
		Vector<Integer> v=new Vector<Integer>();
		v.add(101);
		v.add(102);
		v.add(104);
		v.add(103);
		v.add(102);
		System.out.println(v);
		System.out.println("Tradition Print : ");
		Iterator<Integer> itr=v.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}