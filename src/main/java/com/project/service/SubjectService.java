package com.project.service;

import java.util.List;

import com.project.entities.Subject;

public interface SubjectService 
{
	public void addSubject(Subject subject);
	public List<Subject> getAllSubject();
	public Subject getSubjectById(int subjectId);
    boolean updateSubjectById(int subjectId, Subject updatedSubject);
    boolean deleteSubjectById(int subjectId);
    void deleteAllSubjects();
}
