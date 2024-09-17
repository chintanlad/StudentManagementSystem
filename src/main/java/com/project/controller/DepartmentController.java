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
import com.project.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) 
	{
		this.departmentService = departmentService;
	}
	
	
//	postman - find all
	@GetMapping
    public ResponseEntity<List<Department>> getAllDepartmentP() {
    	List<Department> department = departmentService.getAllDepartment();	
    	return ResponseEntity.ok(department);
    }
	
	
	
// postman - get by id
    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentByIdP(@PathVariable("departmentId") int departmentId) 
    {
    	Department department = departmentService.getDepartmentById(departmentId);
        if (department != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(department);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
	
   
    
    
    
//    {
//        "departmentId":1,
//        "department_name": "CE"
//    }
//	postman - create
	@PostMapping
	public ResponseEntity<String> addDepartmmentP(@RequestBody Department department)
	{
		departmentService.addDepartment(department);
		return ResponseEntity.ok("Department Added..!!!");
	}
	
//	postman - Update department by id
    @PutMapping("/{departmentId}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable("departmentId") int departmentId, @RequestBody Department updatedDepartment) {
        boolean update = departmentService.updateDepartmentById(departmentId, updatedDepartment);
        if (update) {
            return ResponseEntity.ok("Department with ID " + departmentId + " updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department with ID " + departmentId + " not found.");
        }
    }
    
 // Delete Department by ID
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("departmentId") int departmentId) {
        boolean deleted = departmentService.deleteDepartmentById(departmentId);
        if (deleted) {
            return ResponseEntity.ok("Department with ID " + departmentId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department with ID " + departmentId + " not found.");
        }
    }

    // Delete All Departments
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllDepartments() {
        departmentService.deleteAllDepartments();
        return ResponseEntity.ok("All departments deleted successfully.");
    }

}
