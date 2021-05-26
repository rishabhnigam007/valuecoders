package core_java;

import java.util.Scanner;

class Student
{
	public int id;
	public String name;
	
	Student(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public void display()
	{
		System.out.println("Student id is : "+id +" and name is :"+name);
	}
}

public class Array_Of_Object 
{
	public static void main(String[] args) 
	{
		Student s[]=new Student[2];
		s[0]=new Student(1, "rishabh");
		s[1]=new Student(2, "nigam");
		System.out.println("first student : ");
		s[0].display();
		System.out.println("second student : ");
		s[1].display();
		
	}
}