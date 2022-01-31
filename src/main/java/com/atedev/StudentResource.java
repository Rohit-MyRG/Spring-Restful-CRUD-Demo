package com.atedev;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.Dao.StudentDao;
import com.atedev.Bean.Student;

@RestController
public class StudentResource {
	
	@GetMapping("students")
	public List<Student> getStudents() {
				// StudentDao.getAllStudents() Method returns the Student records in the List Type.
		return StudentDao.getAllStudents();
	}
	
	@GetMapping("students/{sno}")
	public Student getStudent(@PathVariable("sno") int sno) {
				// StudentDao.findStudent(int) Method return the Student record.
		return StudentDao.findStudent(sno);
	}
	
	@DeleteMapping("students/{sno}")
	public String deleteStudent(@PathVariable("sno") int sno) {
		
		return StudentDao.deleteStudent(sno)? "Deleted Successfully...":"Sorry, Student not exist";
	}
	
	@PostMapping("students/stud")
	public Student addStudent(@RequestBody Student stud) {
		System.out.println(StudentDao.insertStudent(stud)? "inserted":"Insertion Fail");
		return stud;
	}
	
	@PutMapping("students/stud")
	public Student updateStudent(@RequestBody Student stud) {
		System.out.println(StudentDao.updateStudent(stud)? "Updated": StudentDao.insertStudent(stud)? "inserted": "Updation Fail");
		return stud;
	}
}
