package com.jdbc.store_file;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreFile 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			PreparedStatement ps=con.prepareStatement("insert into filetable values (?,?)");
			
			File f=new File("e:\\credential_and_form.txt");
			FileReader fr=new FileReader(f);
			
			ps.setInt(1, 102);
			ps.setCharacterStream(2, fr, (int)f.length());
			
			int i=ps.executeUpdate();
			System.out.println("Record affected : "+i);
		
			ps.close();
			con.close();	
			System.out.println("File Stored in the database !!");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}

/*
	create table filetable(id int,name longtext);
*/