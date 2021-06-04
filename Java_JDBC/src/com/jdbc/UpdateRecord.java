package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			Statement st=con.createStatement();
			
			String query="update employee set name='happu' where employee_id=1";
			
			st.executeUpdate(query);
			System.out.println("Record Updated Successfully !!");
			
			System.out.println();
			
			PreparedStatement ps=con.prepareStatement("update employee set name=? where employee_id=?");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Name : ");
			String name=sc.nextLine();
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			ps.setInt(2, id);
			ps.setString(1, name);
			
			ps.executeUpdate();
			ps.close();
			System.out.println("Record successfully updated by prepared statement !!");
			
			st.close();
			con.close();
			sc.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}