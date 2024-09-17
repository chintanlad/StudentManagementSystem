package com.project.service;

import java.util.List;

import com.project.entities.Semester;

public interface SemesterService {
	public void addSemester(Semester semester);
	public List<Semester> getAllSemester();
	public Semester getSemesterById(int SemesterId);
	public boolean updateSemesterById(int semesterId, Semester semester);
	boolean deleteSemesterById(int semesterId);
    void deleteAllSemesters();
}
