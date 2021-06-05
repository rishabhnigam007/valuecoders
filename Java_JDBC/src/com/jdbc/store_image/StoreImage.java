package com.jdbc.store_image;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImage 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			PreparedStatement ps=con.prepareStatement("insert into imgtable values (?,?)");
			
			ps.setString(1, "rishabh");
			
			FileInputStream fin=new FileInputStream("e:\\rishabh.jpg");
			ps.setBlob(2, fin, fin.available());
			
			int i=ps.executeUpdate();
			System.out.println("Record affected : "+i);
		
			ps.close();
			con.close();				
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}

/*
	create table imgtable(name varchar(20), photo blob);
*/