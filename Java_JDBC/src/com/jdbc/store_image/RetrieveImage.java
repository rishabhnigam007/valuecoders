package com.jdbc.store_image;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveImage 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			PreparedStatement ps=con.prepareStatement("select * from imgtable");
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				Blob b=rs.getBlob(2);
				byte barr[]=b.getBytes(1, (int)b.length());
				
				FileOutputStream fout=new FileOutputStream("e:\\image\\rishabh.jpg");
				fout.write(barr);
				fout.close();
			}
			
			System.out.println("Record Fetched !! ");
		
			ps.close();
			con.close();				
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}