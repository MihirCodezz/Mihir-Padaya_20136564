package com;

import java.sql.*;

public class EmployeeDetails {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igt","root","1234");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp1");  
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int salary = rs.getInt("salary");
				String desig = rs.getString("desig");
				
				System.out.println("ID: "+ id);
				System.out.println("Name: "+ name);
				System.out.println("Age: "+ age);
				System.out.println("Salary: "+ salary);
				System.out.println("Designation: "+ desig);
				
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
	}
}
