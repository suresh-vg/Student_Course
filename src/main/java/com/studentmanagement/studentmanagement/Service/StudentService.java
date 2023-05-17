package com.studentmanagement.studentmanagement.Service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.studentmanagement.entity.Student;
import com.studentmanagement.studentmanagement.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	
	public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
	
	public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }
	
	
	public Student addStudent(Student student) {
        return studentRepo.save(student);
    }
	
	
	public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = studentRepo.findById(id).orElse(null);

        if (existingStudent != null) {
        	existingStudent.setRollno(updatedStudent.getRollno());
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setBranch(updatedStudent.getBranch());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setPhno(updatedStudent.getPhno());

            return studentRepo.save(existingStudent);
        }

        return null;
    }
	
	public boolean deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
