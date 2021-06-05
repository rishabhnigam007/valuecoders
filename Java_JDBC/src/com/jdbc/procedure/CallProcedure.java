package com.jdbc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallProcedure
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "1234");
			
			CallableStatement cs=con.prepareCall("{call insertr(?,?)}");
			
			cs.setInt(1, 3);
			cs.setString(2, "happu");
			boolean b=cs.execute();
			if(!b)
			{
				System.out.println("Procedure Called and store value!!");
			}
			else
			{
				System.out.println("Procedure Not Called !!");
			}
			cs.close();
			con.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}


/*

Java CallableStatement Interface : CallableStatement interface is used to call the stored procedures and functions.

CREATE TABLE ----->>>>>>>

create table user420(id int,name varchar(20));
desc user420;
select * from user420;

-------------------------

CREATE PROCEDURE ----->>>>>>>

delimiter //
create procedure insertr (in id int,in name varchar(20))
begin
	insert into user420 values(id,name);
end //
delimiter ;

-------------------------

CALLING PROCEDURE ----->>>>>>>

call insertr(1,'rishu');

-------------------------

*/