package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Semester")
public class Semester {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="semesterId",nullable = false)
	private int semesterId;
	
	
//	department and semester many to many
//	@ManyToOne
//	private List<Department> departmentList = new ArrayList<>();

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name="department_semester",
	           joinColumns = @JoinColumn(name = "semesterId", referencedColumnName = "semesterId"),
	           inverseJoinColumns = @JoinColumn(name="departmentId", referencedColumnName = "departmentId"))
//	@JoinColumn(nullable = false)
	private List<Department> departmentList = new ArrayList<>();
	
//	semester and subject many to many
	 @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	 @JoinTable(name="semester_subject",
               joinColumns = @JoinColumn(name = "semesterId", referencedColumnName = "semesterId"),
               inverseJoinColumns = @JoinColumn(name="subjectId", referencedColumnName = "subjectId"))
//	 @JoinColumn(nullable = false)
	 private List<Subject> subjectList = new ArrayList<>();



 
//	semester and student one to many
//	@OneToMany(mappedBy = "semester")
//	private List<Student> studentList = new ArrayList<>();
	
////department and semester many to many
//	 @ManyToMany
//	 @JoinTable(name="department_semester",
//                joinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "departmentId"),
//                inverseJoinColumns = @JoinColumn(name="semesterId", referencedColumnName = "semesterId"))
//    private List<Semester> semesterList = new ArrayList<>();	 

		public int getSemesterId() {
			return semesterId;
		}

		public void setSemesterId(int semesterId) {
			this.semesterId = semesterId;
		}

		public List<Department> getDepartmentList() {
			return departmentList;
		}

		public void setDepartmentList(List<Department> departmentList) {
			this.departmentList = departmentList;
		}

		

		public List<Subject> getSubjectList() {
			return subjectList;
		}

		public void setSubjectList(List<Subject> subjectList) {
			this.subjectList = subjectList;
		}

		public Semester(int semesterId, List<Department> departmentList, List<Subject> subjectList) {
			super();
			this.semesterId = semesterId;
			this.departmentList = departmentList;
			this.subjectList = subjectList;
		}

		public Semester() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	
}
