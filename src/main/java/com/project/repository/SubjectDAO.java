package com.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Subject;


@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

}
