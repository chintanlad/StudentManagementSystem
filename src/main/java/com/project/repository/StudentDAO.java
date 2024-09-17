package com.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Student;


@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

}
