package com.jdbc.rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			// Creating and Executing RowSet
			JdbcRowSet rs=RowSetProvider.newFactory().createJdbcRowSet();
	
			rs.setUrl("jdbc:mysql://localhost:3306/jdbc_db");
			rs.setUsername("root");
			rs.setPassword("1234");
			
			rs.setCommand("select * from user420");
			rs.execute();
			
			while(rs.next())
			{
				// Generating cursor moved event
				System.out.print("ID : "+rs.getInt(1));
				System.out.println(" Name : "+rs.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}


/*

JDBC RowSet : 
The instance of RowSet is the java bean component because it has properties and java bean notification mechanism. It is introduced since JDK 5.

It is the wrapper of ResultSet. It holds tabular data like ResultSet but it is easy and flexible to use.

The implementation classes of RowSet interface are as follows:

JdbcRowSet
CachedRowSet
WebRowSet
JoinRowSet
FilteredRowSet

Note : Jdbc Row Set is able to handle event

*/