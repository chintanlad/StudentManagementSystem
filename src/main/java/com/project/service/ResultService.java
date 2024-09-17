package com.project.service;

import java.util.List;

import com.project.entities.Result;

public interface ResultService 
{
	public void addResult(Result result);
	public Result getResultById(int ResultId);
	public List<Result> getAllResult();
	public boolean updateResultById(int resultId, Result result);
    boolean deleteResultById(int resultId);
    void deleteAllResults();

}
