package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Semester;

@Repository
public interface SemesterDAO extends JpaRepository<Semester, Integer> {

}
