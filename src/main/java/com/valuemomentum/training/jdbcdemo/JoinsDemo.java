package com.valuemomentum.training.jdbcdemo;


		
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
import java.sql.Statement;
//JDBC program to display candidate details and their skills
		public class JoinsDemo
		{
		public static void main(String[] args)
		{
			Connection con;
			Statement stmt;
			ResultSet rs;
			try {
				//register jdbc driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//open a connection
				System.out.println("connecting to database...");
		        con=DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3306/mysqljdbc","root","5337");
		        
		        //execute a query
		        stmt = con.createStatement();
		        rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  "
		        		+ "candidate_skills s ON c.id=candidate_id  INNER JOIN  "
		        		+ "skills sk ON s.skill_id=sk.id  ;"
		        		 );
		        
		        //extract data from result set
		        while(rs.next()) {
		        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		        	
		        	
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

	
	
