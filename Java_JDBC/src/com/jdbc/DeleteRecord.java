package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			Statement st=con.createStatement();
			
			String query = "delete from emp where id=4";
			
			st.execute(query);
			System.out.println("Record Deleted Successfully !!");
			System.out.println();
			
			PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
			System.out.println("Record successfully deleted by prepared statement !!");
			
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