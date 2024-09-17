package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Department;
import com.project.entities.Result;
import com.project.entities.Semester;
import com.project.repository.SemesterDAO;

@Service
public class SemesterServiceImpl implements SemesterService {

	
	private SemesterDAO semesterRepo;
	
	@Autowired
	public SemesterServiceImpl(SemesterDAO semesterRepo) 
	{
		this.semesterRepo = semesterRepo;
	}

	
	public Semester getSemesterById(int SemesterId)
	{
		java.util.Optional<Semester> semester = semesterRepo.findById(SemesterId);
		if(semester.isPresent())
		{
			return semester.get();
		}
		return null;
	}
	
	
//	Get all semester
	public List<Semester> getAllSemester()
	{
		List<Semester> semester = semesterRepo.findAll();
		return semester;
	}

	public void addSemester(Semester semester) 
	{

		semesterRepo.save(semester);
	}
	
	
//	Update Semester By Id
	public boolean updateSemesterById(int semesterId, Semester updatedSemester) {
        java.util.Optional<Semester> existingSemesterOptional = semesterRepo.findById(semesterId);
        if (existingSemesterOptional.isPresent()) {
            Semester existingSemester = existingSemesterOptional.get();
            // Update semester properties here as needed
            // Example: existingSemester.setDepartmentList(updatedSemester.getDepartmentList());
            // You can set other properties similarly

            // Save the updated semester
            semesterRepo.save(existingSemester);
            return true;
        }
        return false;
    }
	
	public boolean deleteSemesterById(int semesterId) {
        java.util.Optional<Semester> semesterOptional = semesterRepo.findById(semesterId);
        if (semesterOptional.isPresent()) {
            semesterRepo.delete(semesterOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllSemesters() {
        semesterRepo.deleteAll();
    }
}


