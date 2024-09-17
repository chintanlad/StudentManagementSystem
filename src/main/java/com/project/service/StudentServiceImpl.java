package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Result;
import com.project.entities.Semester;
import com.project.entities.Student;
import com.project.repository.StudentDAO;


//{
//    "name": "John Doe",
//    "sem": 3,
//    "rollNo": 101,
//    "cpi": 8.5,
//    "result": {
//        "exam_type": "Final",
//        "marks": 85,
//        "pass_fail": "P"
//    },
//    "department": {
//        "branch_name": "Computer Science"
//    }
//}


@Service
public class StudentServiceImpl implements StudentService
{

	private StudentDAO studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentDAO studentRepo) 
	{
		this.studentRepo = studentRepo;
	}
	
	
//	Get all student
	public List<Student> getAllStudent()
	{
		List<Student> student = studentRepo.findAll();
		return student;
	}
	

	public Student getStudentById(int StudentId)
	{
		java.util.Optional<Student> student = studentRepo.findById(StudentId);
		if(student.isPresent())
		{
			return student.get();
		}
		return null;
	}
	
	@Override
	public void addStudent(Student student)
	{	
		studentRepo.save(student);	
	}
	

//	Update Student By Id
	public boolean updateStudentById(int studentId, Student updatedStudent) {
        java.util.Optional<Student> existingStudentOptional = studentRepo.findById(studentId);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            // Update student properties here as needed
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setSem(updatedStudent.getSem());
            existingStudent.setRollNo(updatedStudent.getRollNo());
            existingStudent.setCpi(updatedStudent.getCpi());
            // You can set other properties similarly

            // Save the updated student
            studentRepo.save(existingStudent);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(int studentId) {
        java.util.Optional<Student> studentOptional = studentRepo.findById(studentId);
        if (studentOptional.isPresent()) {
        	studentRepo.delete(studentOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllStudents() {
    	studentRepo.deleteAll();
    }


	

}
