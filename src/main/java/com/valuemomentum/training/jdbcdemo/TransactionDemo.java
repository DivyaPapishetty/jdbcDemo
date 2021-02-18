package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
	        		"jdbc:mysql://localhost:3306/mysqljdbc","root","5337");
	System.out.println("driver is loaded");
		Statement stmt=con.createStatement();
		con.setAutoCommit(false);
		try {
			int i1=stmt.executeUpdate("insert into candidate_skills values(100,3)");
			int i2=stmt.executeUpdate("update skills set name='Ruby' where id=1");
			int i3=stmt.executeUpdate("delete from candidates where id=34");
			con.commit();
			System.out.println("Transaction is success");
		}//end of try
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("Transaction is failed");
			}
		catch(Exception ex)
			{
			System.out.println(ex);
			}
			}//end of catch
		stmt.close();
		con.close();
		System.out.println("connection is closed");
		
		}
	}


