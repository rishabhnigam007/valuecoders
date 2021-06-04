package com.jdbc;

import java.sql.*;

public class MySqlConnection 
{
	public static void main(String[] args) 
	{
		try
		{
			// This class is just like a application.properties file (driver-class-name)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Establised !!");
			
			// This is just like a Session interface and Transaction Interface having commit and rollback methods
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			System.out.println("Database Matched !!");
		
			// This is just like a Query in HQL
			Statement s = con.createStatement();
			System.out.println("Statement Created !!");
			
			//This is just like a like hold all record which is come to database
			ResultSet rs = s.executeQuery("select * from emp");
			System.out.println("Query Executed !!");
	
			System.out.println("<------ Result is ------>");
			while(rs.next()) 
			{
				System.out.println("ID : "+rs.getInt(1)+" || Name : "+rs.getString(2)+" || Gender : "+rs.getString(3));
			}
	
			con.close();
			System.out.println("Connection Closed Successfully !!");
		}
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}		
	}
}

/*

1. Setup Driver Class ("com.mysql.cj.jdbc.Driver")
2. Create Connection using DriverManager (url:"jdbc:mysql://localhost:3306/database_name",username,password)
3. Using Connection interface object create statement
4. Using Statement interface object execute query and store to resultset for printing purpose
5. close the connection object

Note : first add mysql driver jar file to project library folder

link for mysql_driver : https://dbschema.com/jdbc-driver/MySql.html
	
*/

