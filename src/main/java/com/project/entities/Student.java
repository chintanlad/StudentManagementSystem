package com.project.entities;


import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Student")
public class Student {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="student_id", nullable = false)
		private int studentId;
		
		
		@Column(name="name", length=20, nullable = false)
		private String name;
		
		@Column(name="sem", length=10, nullable = false)
		private int sem;
		
		@Column(name="roll_no", length=10, nullable = false)
		private int rollNo;
		
		@Column(name="cpi", length=10, nullable = false)
		private double cpi;
		
//		student and result one to one
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "result", nullable = false)
		private Result result;
		
//		student and department many to one
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "department", nullable = false)
		private Department department;


		
		
//		student and subject one to many
//		@OneToMany(mappedBy = "student")
//		private List<Subject> subjectList = new ArrayList<>();
		
//		student and semester many to one
//		@ManyToOne
//		@JoinColumn(name = "semester", nullable = false)
//		private Semester semester;

//		@ManyToMany
//		@JoinTable(name = "student_subject",
//				   joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"),
//				   inverseJoinColumns = @JoinColumn(name = "subjectId", referencedColumnName = "subjectId"))
//		private List<Subject> subjectList = new ArrayList<>();
				
//		department and semester many to many
//		 @ManyToMany
//		 @JoinTable(name="department_semester",
//	                joinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "departmentId"),
//	                inverseJoinColumns = @JoinColumn(name="semesterId", referencedColumnName = "semesterId"))
//	    private List<Semester> semesterList = new ArrayList<>();
	
		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSem() {
			return sem;
		}

		public void setSem(int sem) {
			this.sem = sem;
		}

		public int getRollNo() {
			return rollNo;
		}

		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}

		public double getCpi() {
			return cpi;
		}

		public void setCpi(double cpi) {
			this.cpi = cpi;
		}

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
//		public Student(int studentId, String name, int sem, int rollNo, double cpi, Result result,
//				Department department)
		public Student(String name, int sem, int rollNo, double cpi, Result result,
				Department department) 
		{
			super();
//			this.studentId = studentId;
			this.name = name;
			this.sem = sem;
			this.rollNo = rollNo;
			this.cpi = cpi;
			this.result = result;
			this.department = department;
		}

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		

}
