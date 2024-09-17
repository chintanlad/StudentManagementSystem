package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int subjectId;

	    @Column(name = "subject_name", length = 25, nullable = false)
	    private String subject_name;
	    
//		subject and student many to many
	    @ManyToMany(mappedBy = "subjectList",cascade = CascadeType.ALL)
		private List<Semester> semesterList = new ArrayList<>();


	    
//		subject and student many to one
//	    @ManyToOne
//		@JoinColumn(name = "studnetId", nullable = false)
//		private Student student;
	    
	    
//		subject and department many to one
//	    @ManyToOne
//		@JoinColumn(name = "subject", nullable = false)
//		private Department department;
	    
		public int getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}

		public String getSubject_name() {
			return subject_name;
		}

		public void setSubject_name(String subject_name) {
			this.subject_name = subject_name;
		}

		public List<Semester> getSemesterList() {
			return semesterList;
		}

		public void setSemesterList(List<Semester> semesterList) {
			this.semesterList = semesterList;
		}

		public Subject(int subjectId, String subject_name, List<Semester> semesterList) {
			super();
			this.subjectId = subjectId;
			this.subject_name = subject_name;
			this.semesterList = semesterList;
		}

		public Subject() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    

	    
}
