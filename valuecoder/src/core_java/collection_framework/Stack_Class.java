package core_java.collection_framework;
import java.util.*;

public class Stack_Class 
{
	public static void main(String[] args) 
	{
		// Stack implement a last in first out order (LIFO)
		// which means element enter last get eliminated first
		
		Stack<Integer> s=new Stack<Integer>();
		s.push(101);
		s.push(108);
		s.push(105);
		s.push(102);
		s.push(104);
		System.out.println("Before delete stack is : ");
		System.out.println(s);
		s.pop();
		System.out.println("after delete : ");
		System.out.println(s);
		Iterator<Integer> itr=s.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("Top element that is going to be eliminated is : "+s.peek());
		
		
	}
}