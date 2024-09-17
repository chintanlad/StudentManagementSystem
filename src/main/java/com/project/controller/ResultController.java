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
import com.project.service.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {
	
	private ResultService resultService;

	@Autowired
	public ResultController(ResultService resultService) 
	{
		this.resultService = resultService;
	}
	
	
//	postman - find all
	@GetMapping
    public ResponseEntity<List<Result>> getAllResultP() 
	{
    	List<Result> result = resultService.getAllResult();	
    	return ResponseEntity.ok(result);
    }
	
	// postman - get by id
    @GetMapping("/{resultId}")
    public ResponseEntity<Result> getDepartmentByIdP(@PathVariable("resultId") int resultId) 
    {
    	Result result = resultService.getResultById(resultId);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
	
    
    
    
//    {
//        "exam_type": "Internal",
//        "marks" : 98,
//        "pass/fail" : "Pass"
//    }
//	postman - create
	@PostMapping
	public ResponseEntity<String> addResultP(@RequestBody Result result)
	{
		resultService.addResult(result);
		return ResponseEntity.ok("Result Added..!!!");
	}
	
//	postman - Update result by id
	
//	 {
//	    "exam_type": "Final",
//	    "marks": 85.5,
//	    "pass_fail": "Fail"
//	  }
	@PutMapping("/{resultId}")
    public ResponseEntity<String> updateResultById(@PathVariable("resultId") int resultId, @RequestBody Result updatedResult) {
        boolean update = resultService.updateResultById(resultId, updatedResult);
        if (update) {
            return ResponseEntity.ok("Result with ID " + resultId + " updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result with ID " + resultId + " not found.");
        }
    }
	
	
	// Delete Result by ID
    @DeleteMapping("/{resultId}")
    public ResponseEntity<String> deleteResultById(@PathVariable("resultId") int resultId) {
        boolean deleted = resultService.deleteResultById(resultId);
        if (deleted) {
            return ResponseEntity.ok("Result with ID " + resultId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result with ID " + resultId + " not found.");
        }
    }

    // Delete all Results
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllResults() {
        resultService.deleteAllResults();
        return ResponseEntity.ok("All Results deleted successfully.");
    }
	

}
