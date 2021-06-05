package com.jdbc.store_file;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFile 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			PreparedStatement ps=con.prepareStatement("select * from filetable");
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				Clob c=rs.getClob(2);
				Reader r=c.getCharacterStream();
				
				// specify filename and its type with location and folder where we want to save this file
				// "c/d/e:\\folder_name\\file_name.format" , example - e:\\image\\file.txt
				FileWriter fw=new FileWriter("e:\\image\\all_credential.txt");
				
				int i;
				while((i=r.read()) != -1)
				{
					fw.write((char)i);
				}
				
				fw.close();
				ps.close();
				con.close();		
				System.out.println("Record Fetched !! ");
			}
			else
			{
				System.out.println("Record Not Found !! ");
			}		
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}