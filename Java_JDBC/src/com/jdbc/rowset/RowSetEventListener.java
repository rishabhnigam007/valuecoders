package com.jdbc.rowset;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

class MyListener implements RowSetListener
{
	@Override
	public void cursorMoved(RowSetEvent event) 
	{
		System.out.println("Cursor Moved...");
	}
	@Override
	public void rowChanged(RowSetEvent event) 
	{
		System.out.println("Cursor Changed...");	
	}
	@Override
	public void rowSetChanged(RowSetEvent event) 
	{
		System.out.println("RowSet Changed...");	
	}
}

public class RowSetEventListener
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
			
			rs.setCommand("select * from emp");
			rs.execute();
			
			// Adding Listener and moving rowset
			rs.addRowSetListener(new MyListener());
			
			while(rs.next())
			{
				// Generating cursor moved event
				System.out.print("ID : "+rs.getInt(1));
				System.out.print(" Name : "+rs.getString(2));
				System.out.println(" Gender : "+rs.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}