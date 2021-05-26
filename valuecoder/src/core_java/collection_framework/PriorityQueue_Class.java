package core_java.collection_framework;
import java.util.*;

public class PriorityQueue_Class 
{
	public static void main(String[] args) 
	{
		// it manage order in terms of priority and assign internally a number for that
		
		PriorityQueue<String> queue=new PriorityQueue<String>();
		queue.add("Amit");  
		queue.add("Vijay");  
		queue.add("JaiShankar");  
		queue.add("Raj");
		
		System.out.println(queue);
		// element() give error when queue is empty
		System.out.println("head:"+queue.element());
		// peek() give null when queue is empty both work same except in term of return
		System.out.println("head:"+queue.peek());
		
		System.out.println("iterating the queue elements:");  
		Iterator<String> itr=queue.iterator();  
		while(itr.hasNext())
		{  
			System.out.println(itr.next());  
		}  
		// remove() does not return null give error
		System.out.println("When using remove() :"+queue.remove());
		// poll() return null if queue is empty
		System.out.println("When using poll() :"+queue.poll());
		System.out.println("after removing two elements:");  
		Iterator<String> itr2=queue.iterator();  
		while(itr2.hasNext())
		{  
			System.out.println(itr2.next());  
		}  
		
		// For insert element at specific position use OFFER() method
		queue.offer("jagannath");
		System.out.println(queue);
		
	}
}