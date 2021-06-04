package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertRecord 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
		Statement st=con.createStatement();
		
		con.setAutoCommit(false);
		st.executeUpdate("insert into emp values (5,'anurag','male')");
		System.out.println("Record insert successfully !!");
		
		//insert by user input
		PreparedStatement ps=con.prepareStatement("insert into emp values (?,?,?)");
		
		System.out.println("New Way to Insert using user input from console : ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter ID : ");
		int id=Integer.parseInt(br.readLine());
		
		System.out.println("Enter Name : ");
		String name=br.readLine();
		
		System.out.println("Enter Gender : ");
		String gender=br.readLine();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, gender);
		
		ps.executeUpdate();
		
		con.commit();
		System.out.println("Record successfully saved in the database !!");
		con.close();
	}
}