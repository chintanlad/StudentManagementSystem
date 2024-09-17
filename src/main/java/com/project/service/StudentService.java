package com.project.service;

import java.util.List;

import com.project.entities.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int StudentId);
	public boolean updateStudentById(int studentId, Student student);
	boolean deleteStudentById(int studentId);
    void deleteAllStudents();
}
