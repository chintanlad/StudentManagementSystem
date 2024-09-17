package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Student;
import com.project.entities.Subject;
import com.project.repository.SubjectDAO;

@Service
public class SubjectServiceImpl implements SubjectService
{
	private final SubjectDAO subjectRepo;

    @Autowired
    public SubjectServiceImpl(SubjectDAO subjectRepo) 
    {
        this.subjectRepo = subjectRepo;
    }
    
//	Get all Subject
	public List<Subject> getAllSubject()
	{
		List<Subject> subject = subjectRepo.findAll();
		return subject;
	
	}
    
	public Subject getSubjectById(int subjectId)
	{
		java.util.Optional<Subject> subject = subjectRepo.findById(subjectId);
		if(subject.isPresent())
		{
			return subject.get();
		}
		return null;
	}
	
    @Override
    public void addSubject(Subject subject)
    {
        subjectRepo.save(subject);
    }
    
    @Override
    public boolean updateSubjectById(int subjectId, Subject updatedSubject) {
        java.util.Optional<Subject> subjectOptional = subjectRepo.findById(subjectId);
        if (subjectOptional.isPresent()) {
            updatedSubject.setSubjectId(subjectId);
            subjectRepo.save(updatedSubject);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSubjectById(int subjectId) {
    	 java.util.Optional<Subject> subjectOptional = subjectRepo.findById(subjectId);
        if (subjectOptional.isPresent()) {
        	subjectRepo.delete(subjectOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllSubjects() {
    	subjectRepo.deleteAll();
    }

}
