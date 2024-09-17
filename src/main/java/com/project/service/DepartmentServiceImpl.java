package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.Department;
import com.project.entities.Result;

import com.project.repository.DepartmentDAO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO departmentRepo;
	
	public DepartmentServiceImpl(@Autowired DepartmentDAO departmentRepo) 
	{
		this.departmentRepo = departmentRepo;
	}

	@Override
	public void addDepartment(Department department) 
	{
		departmentRepo.save(department);
	}

	
//	Get all department
	public List<Department> getAllDepartment()
	{
		List<Department> department = departmentRepo.findAll();
		return department;
	}

	
//	Get Department By Id
	public Department getDepartmentById(int DepartmentId)
	{
		java.util.Optional<Department> department = departmentRepo.findById(DepartmentId);
		if(department.isPresent())
		{
			return department.get();
		}
		return null;
	}
	
	
//	Update department By Id
	@Transactional
    public boolean updateDepartmentById(int departmentId, Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = departmentRepo.findById(departmentId);
        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();
            // Update department properties here as needed
            existingDepartment.setdepartment_name(updatedDepartment.getdepartment_name());
            // You can set other properties similarly

            // Save the updated department
            departmentRepo.save(existingDepartment);
            return true;
        }
        return false;
    }
	
	public boolean deleteDepartmentById(int departmentId) {
        Optional<Department> departmentOptional = departmentRepo.findById(departmentId);
        if (departmentOptional.isPresent()) {
            departmentRepo.delete(departmentOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllDepartments() {
        departmentRepo.deleteAll();
    }
	
	
}
