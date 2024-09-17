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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.Department;
import com.project.entities.Result;
import com.project.entities.Semester;
import com.project.service.DepartmentService;
import com.project.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterController {
	
	private SemesterService semesterService;
	private DepartmentService departmentService;
	
	
	@Autowired
	public SemesterController(SemesterService semesterService, DepartmentService departmentService) 
	{
		this.semesterService = semesterService;
		this.departmentService = departmentService;
	}
	
	
//	postman - find all
	@GetMapping
    public ResponseEntity<List<Semester>> getAllSemesterP() 
	{
    	List<Semester> semester = semesterService.getAllSemester();	
    	return ResponseEntity.ok(semester);
    }
	
	
//	postman - find by id
    @GetMapping("/{semesterId}")
    public ResponseEntity<Semester> getDepartmentByIdP(@PathVariable("semesterId") int semesterId) 
    {
    	Semester semester = semesterService.getSemesterById(semesterId);
        if (semester != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(semester);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
	
//    postman - add Semester
    
//    {
//        "semester_id": 4
//    }
	@PostMapping
	public ResponseEntity<String> addSemesterP(@RequestBody Semester semester)
	{
		semesterService.addSemester(semester);
		return ResponseEntity.ok("Semester Added..!!!");
//		int departmentId = semester.getDepartmentList().getBranchId();
//		Department department = departmentService.getDepartmentById(departmentId);
		
	}
	
	
//	postman - Semester result by id
	@PutMapping("/{semesterId}")
    public ResponseEntity<String> updateSemesterById(@PathVariable("semesterId") int semesterId, @RequestBody Semester updatedSemester) {
        boolean update = semesterService.updateSemesterById(semesterId, updatedSemester);
        if (update) {
            return ResponseEntity.ok("Semester with ID " + semesterId + " updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Semester with ID " + semesterId + " not found.");
        }
    }
	
	// Delete Result by ID
	@DeleteMapping("/{semesterId}")
    public ResponseEntity<String> deleteSemesterById(@PathVariable("semesterId") int semesterId) {
        boolean deleted = semesterService.deleteSemesterById(semesterId);
        if (deleted) {
            return ResponseEntity.ok("Semester with ID " + semesterId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Semester with ID " + semesterId + " not found.");
        }
    }

    // Delete All Semesters
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllSemesters() {
        semesterService.deleteAllSemesters();
        return ResponseEntity.ok("All semesters deleted successfully.");
    }
	

}
