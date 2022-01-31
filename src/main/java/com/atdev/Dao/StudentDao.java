package com.atdev.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atedev.Bean.Student;

public class StudentDao {
	private static Connection con = null;
	
	static{
		con = MySqlConnectionProvider.getConnection();
	}
	
	// Insert a Student in Database
	public static boolean insertStudent(Student stud) {
		try {
			if(findStudent(stud.getSno()) == null) {
				PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?)");
				pst.setInt(1, stud.getSno());
				pst.setString(2, stud.getName());
				pst.setDate(3, new java.sql.Date(stud.getDob().getTime()));
				pst.setDate(4, new java.sql.Date(stud.getDoj().getTime()));
				
				return (pst.executeUpdate() == 1)? true : false; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Update a Student Data
	public static boolean updateStudent(Student stud) {
		try {
				PreparedStatement pst = con.prepareStatement("update student set name=?, dob=?, doj=? where sno=?");
				pst.setString(1, stud.getName());
				pst.setDate(2, new java.sql.Date(stud.getDob().getTime()));
				pst.setDate(3, new java.sql.Date(stud.getDoj().getTime()));
				pst.setInt(4, stud.getSno());
				
				return (pst.executeUpdate() == 1)? true : false; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Delete Student Record
	public static boolean deleteStudent(int sno) {
		try {
				PreparedStatement pst = con.prepareStatement("delete from student where sno=?");
				pst.setInt(1, sno);
				
				return (pst.executeUpdate() == 1)? true : false; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Find a Student data 
	public static Student findStudent(int sno) {
		
		try {
				PreparedStatement pst = con.prepareStatement("select * from student where sno=?");
				pst.setInt(1, sno);
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					Student stud = new Student();
					stud.setSno(rs.getInt("sno"));
					stud.setName(rs.getString("name"));
					stud.setDob(rs.getDate("dob"));
					stud.setDoj(rs.getDate("doj"));
					
					return stud;
				}else {
					return null;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Select the student Records
	public static List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Student stud = new Student();
				stud.setSno(rs.getInt("sno"));
				stud.setName(rs.getString("name"));
				stud.setDob(rs.getDate("dob"));
				stud.setDoj(rs.getDate("doj"));
				
				studentList.add(stud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
}
