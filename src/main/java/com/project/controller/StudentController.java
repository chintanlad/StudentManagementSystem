package com.project.controller;

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

import com.project.entities.Department;
import com.project.entities.Result;
import com.project.entities.Semester;
import com.project.entities.Student;
import com.project.service.DepartmentService;
import com.project.service.ResultService;
import com.project.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	
	
	// {
//  "name": "Chintan",
//  "sem": 4,
//  "rollNo": 61,
//  "cpi": 9.7,
//  "result": {
//    "exam_type": "External",
//    "marks": 95.5,
//    "pass_fail": "Final"
//  },
//  "department": {

//    "department_id":1,
//    "department_name": "CE"
//  }
//}
	
	private StudentService studentService;
	private ResultService resultService;
	private DepartmentService departmentService;

	@Autowired
	public StudentController(StudentService studentService, ResultService resultService,
			DepartmentService departmentService) 
	{
		
		this.studentService = studentService;
		this.resultService = resultService;
		this.departmentService = departmentService;
	}

	
//	postman - find all
	@GetMapping
    public ResponseEntity<List<Student>> getAllStudentP() 
	{
    	List<Student> student = studentService.getAllStudent();	
    	return ResponseEntity.ok(student);
    }
	
//	postman - find by id
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getDepartmentByIdP(@PathVariable("studentId") int studentId) 
    {
    	Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
	
//	Add the Student
    
//    {
//    	  "name": "John Doe",
//    	  "sem": 2,
//    	  "rollNo": 101,
//    	  "cpi": 8.5,
//    	  "result": {
//    	    "exam_type": "Final",
//    	    "marks": 85.5,
//    	    "pass_fail": "Pass"
//    	  },
//    	  "department": {
//    	    "department_name": "CE"
//    	  }
//    	}
	@PostMapping
	public ResponseEntity<String> addStudentP(@RequestBody Student student)
	{
		 	
//		int resultId = student.getResult().getResult_id();
//		Result result = resultService.getResultById(resultId);
//		
//		int departmentId = student.getDepartment().getBranchId();
//		Department department = departmentService.getDepartmentById(departmentId);
//		
//		
//		student.setDepartment(department);
//		student.setResult(result);
		
		studentService.addStudent(student);
		return ResponseEntity.ok("Student added..!!!");
	}
	
	
//	postman - Student result by id
	
//		{
//		  "name": "Jay",
//		  "sem": 2,
//		  "rollNo": 101,
//		  "cpi": 8.5
//		}
    @PutMapping("/{studentId}")
    public ResponseEntity<String> updateStudentById(@PathVariable("studentId") int studentId, @RequestBody Student updatedStudent) {
        boolean updated = studentService.updateStudentById(studentId, updatedStudent);
        if (updated) {
            return ResponseEntity.ok("Student with ID " + studentId + " updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + studentId + " not found.");
        }
    }

    // Delete Student by ID
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") int studentId) {
        boolean deleted = studentService.deleteStudentById(studentId);
        if (deleted) {
            return ResponseEntity.ok("Student with ID " + studentId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + studentId + " not found.");
        }
    }

    // Delete All Students
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.ok("All students deleted successfully.");
    }
	



}
