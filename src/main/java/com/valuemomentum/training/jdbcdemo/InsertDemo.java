package com.valuemomentum.training.jdbcdemo;


		import java.beans.Statement;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;

		public class InsertDemo
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
		        String str="insert into skills(name)"+"values('html5')";
		        //execute a query
		         java.sql.Statement stmt = con.createStatement();
		         int rowcount = stmt.executeUpdate(str);
		        		 
		        		 
		        		 if(rowcount >0)
		        		 {
		        			 System.out.println("record inserted successfully");
		        		 }
		         String str1="select count(id) from skills";
		        rs=stmt.executeQuery(str1);
		        
		        
		        int cnt = 0;
				//extract data from result set
		        while(rs.next())
		        {
			        cnt=rs.getInt(1);}
		        	System.out.println("total no. of records is:"+cnt);
		        	con.close();
		        }
		
			
		catch (Exception ce) {
			System.out.println(ce);
		}
		}
	

	
	

	}


