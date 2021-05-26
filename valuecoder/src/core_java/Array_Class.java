package core_java;

import java.util.*;

public class Array_Class {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		int size=sc.nextInt();
		int a[]=new int[size];
		System.out.println("Enter the array element : ");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Array is :");
		System.out.println(Arrays.toString(a));
		sc.close();
	}
}