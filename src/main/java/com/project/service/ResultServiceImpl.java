package com.project.service;

import java.util.List;

import org.apache.el.stream.Optional;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Department;
import com.project.entities.Result;
import com.project.repository.ResultDAO;

@Service
public class ResultServiceImpl implements ResultService {

	
	private ResultDAO resultRepo;
	
	public ResultServiceImpl(@Autowired ResultDAO resultRepo) 
	{
		this.resultRepo = resultRepo;
	}


	@Override
	public void addResult(Result result) 
	{
		resultRepo.save(result);	
	}
	
//	Get all result
	public List<Result> getAllResult()
	{
		List<Result> result = resultRepo.findAll();
		return result;
	}
	
	@Override
	public Result getResultById(int ResultId)
	{
		java.util.Optional<Result> result = resultRepo.findById(ResultId);
		if(result.isPresent())
		{
			return result.get();
		}
		return null;
	}

	
	
//	Update result By Id
	public boolean updateResultById(int resultId, Result updatedResult) {
        java.util.Optional<Result> existingResultOptional = resultRepo.findById(resultId);
        if (existingResultOptional.isPresent()) {
            Result existingResult = existingResultOptional.get();
            existingResult.setExam_type(updatedResult.getExam_type());
            existingResult.setMarks(updatedResult.getMarks());
            existingResult.setPass_fail(updatedResult.getPass_fail());
            resultRepo.save(existingResult);
            return true;
        }
        return false;
    }
	
	public boolean deleteResultById(int resultId) {
        java.util.Optional<Result> resultOptional = resultRepo.findById(resultId);
        if (resultOptional.isPresent()) {
            resultRepo.delete(resultOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllResults() {
        resultRepo.deleteAll();
    }
}
