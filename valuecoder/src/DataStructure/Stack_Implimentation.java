package DataStructure;

import java.util.Scanner;

public class Stack_Implimentation 
{
	public int size;
	private int top;
	private int stack[];
	
	public Stack_Implimentation(int size) 
	{
		this.size=size;
		top=-1;
		stack=new int[size];
	}
	boolean isFull()
	{
		return top==stack.length-1;
	}
	boolean isEmpty()
	{
		return top==-1;
	}
	boolean push(int data)
	{
		if(isFull())
		{
			System.out.println("Stack is full : overflow !!");
			return false;
		}
		else
		{
			top=top+1;
			stack[top]=data;
			return true;
		}
	}
	int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty : underflow !!");
			return 0;
		}
		else
		{
			size--;
			return stack[top--];
		}
	}
	void display()
	{
		System.out.println("Stack Size is : "+size);
		System.out.print("Stack element is : ");
		for(int i=size-1;i>=0;i--)
		{
			System.out.print(stack[i]+" ");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the stack : ");
		int size=sc.nextInt();
		Stack_Implimentation s=new Stack_Implimentation(size);
		System.out.println("Enter the Element in Stack : ");
		for(int i=0;i<size;i++)
		{
			int x=sc.nextInt();
			s.push(x);
		}
		System.out.println("After Pushing Element in stack is : ");
		s.display();
		System.out.println();
		System.out.println("Enter how many items you want to POP : ");
		int total=sc.nextInt();
		if(total<=size)
		{
			System.out.println("After POP "+total+" Element in stack : ");
			for(int j=0;j<total;j++)
			{
				int x=s.pop();
				System.out.println((j+1)+" item pop is : "+x);
			}
			
			//s.display();
		}
		else
		{
			System.out.println("Underflow !!");
		}
		sc.close();		
	}
}