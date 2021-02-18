package com.valuemomentum.training.jdbcdemo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DeleteDemo
{
public static void main(String[] args)
{
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
        
        String sql="Delete from candidates where rtrim(last_name) like\'Y\';";
        System.out.println(" ");
        java.sql.Statement stmt = con.createStatement();
        int cnt = stmt.executeUpdate(sql);
        
        if(cnt>0)
        	
        {
        	System.out.println("record for young is deleted");
        }
        else
        {
        	System.out.println("record");
        }
        
        con.close();
	}
	catch(Exception ce) {
		System.out.println(ce);
	}
	}
}