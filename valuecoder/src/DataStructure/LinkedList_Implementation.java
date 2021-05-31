package DataStructure;

//Defining Structure
class Node
{
	public int data;
	public Node next;
	
	public void displayNodeData()
	{
		System.out.print("{ "+data+" }"+"-");
	}
}

public class LinkedList_Implementation 
{
	private Node head;
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
	// insert node at first location
	public void insertFirst(int data)
	{
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=head;
		head=newNode;
	}
	
	// insert node at last location
	public void insertLast(int data)
	{
		Node current=head;
		while(current.next!=null)
		{
			current=current.next;
		}
		Node newNode=new Node();
		newNode.data=data;
		current.next=newNode;
	}
	
	// delete node at first location
	public Node deleteFirst()
	{
		Node temp=head;
		head=head.next;
		return temp;
	}
	
	// delete node at last location
	public void deleteAfter(Node after)
	{
		Node temp=head;
		while(temp.next != null && temp.data != after.data)
		{
			temp=temp.next;
		}
		if(temp.next != null)
			temp.next=temp.next.next;
	}
	
	// delete node at last location
	public void printLinkedList()
	{
		System.out.println("Printing Linkedlist (head --> last) ");
		Node current=head;
		while(current != null)
		{
			current.displayNodeData();
			current=current.next;
		}
		System.out.println();
	}
	
	// Driver code
	public static void main(String[] args) 
	{
		LinkedList_Implementation ll=new LinkedList_Implementation();
		ll.insertFirst(10);
		ll.insertFirst(60);
		ll.insertFirst(30);
		ll.insertFirst(40);
		ll.insertLast(55);
		
		ll.printLinkedList();
		// linked list will be 
		// 40-> 30-> 60-> 10-> 55
		
		System.out.println("====================================");
		System.out.println("Deleting node after node 60");
		Node node=new Node();
		node.data=60;
		ll.deleteAfter(node);
		// after deleting node 
		// linkedlist will be
		// 40-> 30-> 60-> 55
		
		System.out.println("====================================");
		ll.printLinkedList();
		
	}
}