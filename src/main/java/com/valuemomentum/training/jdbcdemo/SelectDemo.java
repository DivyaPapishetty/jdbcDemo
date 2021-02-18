package com.valuemomentum.training.jdbcdemo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SelectDemo {

	public static void main(String[] args) {
	
			Connection con;
			Statement stmr;
			ResultSet rs;
			try {
				//register jdbc driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//open a connection
				System.out.println("connecting to database...");
		        con=DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3306/mysqljdbc","root","5337");
		        
		        //execute a query
		        java.sql.Statement stmt = con.createStatement();
		        rs=stmt.executeQuery("select * from candidates");
		        
		        //extract data from result set
		        while(rs.next()) {
		        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString("phone")+
		        			" "+rs.getString(6));
		        	
		        }
				rs.close();
				stmt.close();
				con.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}

				
}
				
			
		

	
