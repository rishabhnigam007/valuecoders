package DataStructure;

import java.util.Scanner;

public class Queue_Implimentation 
{
	public int size;
	private int total;
	private int front;
	private int rear;
	private int queue[];
	
	public Queue_Implimentation(int size)
	{
		this.size=size;
		total=0;
		front=0;
		rear=0;
		queue=new int[size];
	}
	
	boolean isFull()
	{
		if(size==total)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	boolean isEmpty()
	{
		if(front==0 && rear==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	boolean enqueue(int data)
	{
		if(isFull())
		{
			System.out.println("Overflow !!");
			return false;
		}
		else
		{
			total=total+1;
			queue[rear]=data;
			rear=rear+1;
			return true;
		}
	}
	
	int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Underflow !!");
			return 0;
		}
		else
		{
			int data=queue[front];
			front=front+1;
			total=total-1;
			//size=size-1;
			return data;
		}
	}
	
	void display()
	{
		System.out.println("Size of the queue is : "+size);
		System.out.println("Total is : "+total);
		System.out.print("Queue Element is : ");
		for(int i=front;i<rear;i++)
		{
			System.out.print(queue[i]+" ");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the Queue : ");
		int size=sc.nextInt();
		Queue_Implimentation q=new Queue_Implimentation(size);
		System.out.println("Enter the Queue Element : ");
		for(int i=0;i<size;i++)
		{
			q.enqueue(sc.nextInt());
		}
		q.display();
		System.out.println();
		System.out.println("Enter how many element you want to Dequeue : ");
		int deq=sc.nextInt();
		if(deq<=size)
		{
			for(int i=0;i<deq;i++)
			{
				System.out.println((i+1)+" element dequeue is : "+q.dequeue());
			}
			System.out.println("After Dequeue of "+deq+" element : ");
			q.display();
		}
		else
		{
			System.out.println("Not Possible !!");
		}
		System.out.println();
		sc.close();
	}
}