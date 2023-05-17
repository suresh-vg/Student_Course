package com.studentmanagement.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.studentmanagement.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
