package core_java.collection_framework;
import java.util.*;

public class TreeSet_Class 
{
	public static void main(String[] args) 
	{
		// TreeSet class contain unique elements only like hashset
		// access and retrieval time quiet fast
		// TreeSet class does not allow null element
		// TreeSet class is non synchronized
		// It maintain Increasing order
		
		TreeSet<Integer> tree=new TreeSet<Integer>();
		tree.add(123);
		tree.add(456);
		tree.add(130);
		System.out.println("Initial Tree : "+tree);
		System.out.println("Reverse Tree : "+tree.descendingSet());
		// To get First element
		System.out.println("First element : "+tree.first());
		// To get Last element
		System.out.println("Last element : "+tree.last());
		System.out.print("Ascending order Traversal : ");
		Iterator<Integer> it=tree.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		System.out.println();
		System.out.print("Decending order Traversal : ");
		Iterator<Integer> itr=tree.descendingIterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		//root element
		System.out.println("Highest value : "+tree.pollFirst());
		// last child
		System.out.println("Lowest value : "+tree.pollLast());
		// Both operation can delete the element
		System.out.println(tree);

		tree.add(112);
		tree.add(120);
		tree.add(141);
		tree.add(152);
		System.out.println("Particular element to last : "+tree.tailSet(130));
		
		
		
	}
}