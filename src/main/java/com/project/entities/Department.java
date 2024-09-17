package com.project.entities;




import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")
public class Department 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="departmentId", length=10, nullable = false)
		private int departmentId;
		
		@Column(name="department_name", length=30, nullable = false)
		private String department_name;
		
		
//  	department and student one to many
		@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//		@JoinColumn(nullable = false)
		private List<Student> studentList = new ArrayList<>();

				
//    	department and semester one to many
//		@OneToMany(mappedBy = "departmentList")
//		private List<Semester> semesterList = new ArrayList<>();
		@ManyToMany(mappedBy = "departmentList", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		private List<Semester> semesterList = new ArrayList<>();

		
	////	department and semester many to many
	//	 @ManyToMany
	//	 @JoinTable(name="department_semester",
	//                joinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "departmentId"),
	//                inverseJoinColumns = @JoinColumn(name="semesterId", referencedColumnName = "semesterId"))
	//    private List<Semester> semesterList = new ArrayList<>();	 
		

		
//    	department and subject one to many
//		@OneToMany(mappedBy = "department")
//		private List<Subject> subjectList = new ArrayList<>();
		 
		 
	
	//	 Getter, Setter and Constructor
		public int getdepartmentId() {
			return departmentId;
		}


		public void setdepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}


		public String getdepartment_name() {
			return department_name;
		}


		public void setdepartment_name(String department_name) {
			this.department_name = department_name;
		}


		public List<Student> getStudentList() {
			return studentList;
		}


		public void setStudentList(List<Student> studentList) {
			this.studentList = studentList;
		}


		public List<Semester> getSemesterList() {
			return semesterList;
		}


		public void setSemesterList(List<Semester> semesterList) {
			this.semesterList = semesterList;
		}





		public Department(int departmentId, String department_name, List<Student> studentList, List<Semester> semesterList) {
			super();
			this.departmentId = departmentId;
			this.department_name = department_name;
			this.studentList = studentList;
			this.semesterList = semesterList;
		}
		
	    public Department(String department_name) {
	        this.department_name = department_name;
	    }


		public Department() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
