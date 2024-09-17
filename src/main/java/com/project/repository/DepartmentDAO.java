package com.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Department;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer> {

}