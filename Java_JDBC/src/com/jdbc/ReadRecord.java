package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadRecord 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
				
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from emp");
		
		System.out.println("All Records !!");
		while(rs.next())
		{
			System.out.println("ID : "+rs.getInt(1)+" || Name : "+rs.getString(2)+" || Gender : "+rs.getString(3));
		}
		System.out.println();
		
		// getting record only 3rd row
		rs.absolute(3);
		System.out.println("Record Only 3rd Row !!");
		System.out.println();
		System.out.println("ID : "+rs.getInt(1)+" || Name : "+rs.getString(2)+" || Gender : "+rs.getString(3));
		
		con.close();
	}
}

/*

Output : 

All Records !!
ID : 1 || Name : rishabh || Gender : male
ID : 2 || Name : vikash || Gender : male
ID : 3 || Name : shiva || Gender : female
ID : 4 || Name : gulafsha || Gender : female
ID : 5 || Name : anurag || Gender : male
ID : 6 || Name : rishabh nigam || Gender : male

Record Only 3rd Row !!

ID : 3 || Name : shiva || Gender : female

*/