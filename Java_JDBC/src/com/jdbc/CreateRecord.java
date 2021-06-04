package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CreateRecord 
{

	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Table Name : ");
			String tableName=sc.next();
			
			String query="create table "+tableName+" (employee_id int not null,name varchar(20) not null,salary int not null,primary key (employee_id) )";
			
			// or
			
//			String query = "create table employee (employee_id int not null,name varchar(20) not null,salary int not null,primary key (employee_id) ) ";
		
			st.execute(query);
			st.close();
			con.close();
			sc.close();
			System.out.println("Table Created Successfully !!");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}