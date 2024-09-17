package com.project.service;

import java.util.List;

import com.project.entities.Department;

public interface DepartmentService {
	public void addDepartment(Department department);

	public List<Department> getAllDepartment();
	public Department getDepartmentById(int departmentId);
	public boolean updateDepartmentById(int departmentId, Department department);
	boolean deleteDepartmentById(int departmentId);
    void deleteAllDepartments();
}
