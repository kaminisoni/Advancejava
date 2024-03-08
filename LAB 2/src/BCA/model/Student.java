package BCA.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	public Student() {
		super();
		
	}
public void insertStudent(Connection con, Scanner sc) throws SQLException {
		
		// Create statement
		Statement st = con.createStatement();
		//read student details
		System.out.println("Enter the Student Name:");
		String sname = sc.next();
		System.out.println("Enter the student Roll Number:");
		int roll_no = sc.nextInt();
		System.out.println("Enter Student Address: ");
		String address = sc.next();
		// create sql query string
				//create sql squery string
	String query = String.format("Insert Into student values('%s', %d, '%s') ", sname, roll_no, address);
				//excecute sql quesry
				int rows = st.executeUpdate(query);
				
				System.out.println(rows + " record inserted!!!");
				
			}
public void displaystudent(Connection con) throws SQLException {
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from student");
	
	while(rs.next()) {
		System.out.println(rs.getString(1)+ "\t"+rs.getInt(2)+ "\t"+ rs.getString(3));
	}
	
}
public void updatestudentname(Connection con, Scanner sc) throws SQLException {
	Statement st = con.createStatement();
	System.out.println("Enter Student Roll: ");
	int roll_no = sc.nextInt();
	System.out.println("Enter Student New Name: ");
	String sname = sc.next();
	
	String query = String.format("update student set sname='%s' where roll_no = %d", sname, roll_no);
	int rowsAffected = st.executeUpdate(query);
	System.out.println(rowsAffected+" recored updated!!!");
	
}
public void removestudent(Connection con, Scanner sc) throws SQLException {
	Statement st = con.createStatement();
	System.out.println("Enter Student Roll: ");
	int roll_no = sc.nextInt();
	
	int rowAffected = st.executeUpdate("delete from student where roll_no = "+roll_no);
	System.out.println(rowAffected + " recored deleted!!!");
	
	
}

}
		