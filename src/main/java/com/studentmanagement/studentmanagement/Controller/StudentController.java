package com.studentmanagement.studentmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.studentmanagement.Service.StudentService;
import com.studentmanagement.studentmanagement.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@GetMapping("/All")
	public ResponseEntity<List<Student>> getAll()
	{
		List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
	        Student student = studentService.getStudentById(id);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 
	    @PostMapping
	    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
	        Student createdStudent = studentService.addStudent(student);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
	        Student student = studentService.updateStudent(id, updatedStudent);

	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	        boolean deleted = studentService.deleteStudent(id);

	        if (deleted) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


	 
	 
	

}
