package org.sindu.restapi.databinding.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.sindu.restapi.databinding.entity.Student;
import org.sindu.restapi.databinding.exceptionhandling.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
	List<Student> students;

	@PostConstruct
	public void initLoad() {
		 students = new ArrayList<>();
		 students.add(new Student(0, "John", "Daniel", false));
		 students.add(new Student(1, "Dany", "Brute", false));
		 students.add(new Student(2, "Mary", "John", false));
		 students.add(new Student(3, "Christy", "Avy", false));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found" +studentId);
		}
		return students.get(studentId);
	}
	
}
