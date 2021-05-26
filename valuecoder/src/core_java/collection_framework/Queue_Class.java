package core_java.collection_framework;
import java.util.*;

public class Queue_Class 
{
	public static void main(String[] args) 
	{
		// add and remove element from both sides
		// NULL ELEMENT ARE NOT ALLOWED IN THE ARRAYDEQUE
		// This is not thread safe
		//ArrayDeque is faster than LinkedList and Stack
		//It has no capacity restriction
		
		Deque<Integer> queue=new ArrayDeque<Integer>();
		queue.add(201);
		queue.add(202);
		queue.add(205);
		queue.add(209);
		System.out.println(queue);
		queue.offer(503);
		System.out.println("before offerFirst : ");
		System.out.println(queue);
		queue.offerFirst(606);
		System.out.println("after offerFirst : ");
		System.out.println(queue);
		
		// Traversal using for each loop
		for(Integer i:queue)
		{
			System.out.println(i);
		}
		queue.poll();
		System.out.println("after poll : ");
		System.out.println(queue);
		
		queue.pollFirst();
		System.out.println("after pollFirst : ");
		System.out.println(queue);
		
		// poll or pollFirst both are same they delete first element
		
	}
}