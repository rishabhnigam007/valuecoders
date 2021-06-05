package com.jdbc;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.*;

public class ResultSetMetaData 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			PreparedStatement ps=con.prepareStatement("select * from emp");
			
			ResultSet rs=ps.executeQuery();
			
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();
			
			System.out.println("Total columns : "+rsmd.getColumnCount());
			System.out.println("Column Name of 1st column : "+rsmd.getColumnName(1));
			System.out.println("Column Type of 1st column : "+rsmd.getColumnTypeName(1));
		
			rs.close();
			ps.close();
			con.close();			
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}