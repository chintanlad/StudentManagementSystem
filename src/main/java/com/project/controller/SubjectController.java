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

import com.project.entities.Student;
import com.project.entities.Subject;
import com.project.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController 
{
	private SubjectService subjectService;

	@Autowired
    public SubjectController(SubjectService subjectService) 
	{
        this.subjectService = subjectService;
    }
	
//	postman - find all
	@GetMapping
    public ResponseEntity<List<Subject>> getAllSubjectP() 
	{
    	List<Subject> subject = subjectService.getAllSubject();	
    	return ResponseEntity.ok(subject);
    }
	
	
	
//	postman - find by id
    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getDepartmentByIdP(@PathVariable("subjectId") int subjectId) 
    {
    	Subject subject = subjectService.getSubjectById(subjectId);
        if (subject != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(subject);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    
//	postman - add Subject
    
 // {
//  "subject_name": "JT"
//}
	@PostMapping
    public ResponseEntity<String> addSubject(@RequestBody Subject subject)
	{
        subjectService.addSubject(subject);
        return ResponseEntity.ok("Subject Added..!!!");
    }
	
    @PutMapping("/{subjectId}")
    public ResponseEntity<String> updateSubjectById(@PathVariable("subjectId") int subjectId, @RequestBody Subject updatedSubject) {
        boolean updated = subjectService.updateSubjectById(subjectId, updatedSubject);
        if (updated) {
            return ResponseEntity.ok("Subject with ID " + subjectId + " updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject with ID " + subjectId + " not found.");
        }
    }

    // Delete Subject by ID
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable("subjectId") int subjectId) {
        boolean deleted = subjectService.deleteSubjectById(subjectId);
        if (deleted) {
            return ResponseEntity.ok("Subject with ID " + subjectId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject with ID " + subjectId + " not found.");
        }
    }

    // Delete All Subjects
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllSubjects() {
        subjectService.deleteAllSubjects();
        return ResponseEntity.ok("All subjects deleted successfully.");
    }

	
}
