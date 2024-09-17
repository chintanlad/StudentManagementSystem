package com.project.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="Result")
public class Result {
		
		
		@Id
		@Column(name="resultId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int result_id;
		
		@Column(name="exam_type", length=10)
		private String exam_type;
		
		@Column(name="mark", length=3)
		private double marks;
		
		@Column(name="pass/fail", length=10)
		private String pass_fail;

//		result and student one to one
		@OneToOne(mappedBy = "result",cascade = CascadeType.ALL)
		private Student student;

		
		
		public void setResult_id(int result_id) {
			this.result_id = result_id;
		}

		public void setExam_type(String exam_type) {
			this.exam_type = exam_type;
		}

		public void setMarks(double marks) {
			this.marks = marks;
		}

		public void setPass_fail(String pass_fail) {
			this.pass_fail = pass_fail;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public int getResult_id() {
			return result_id;
		}

		public String getExam_type() {
			return exam_type;
		}

		public double getMarks() {
			return marks;
		}

		public String getPass_fail() {
			return pass_fail;
		}

		public Student getStudent() {
			return student;
		}

		public Result() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Result(int result_id, String exam_type, double marks, String pass_fail, Student student) {
			super();
			this.result_id = result_id;
			this.exam_type = exam_type;
			this.marks = marks;
			this.pass_fail = pass_fail;
			this.student = student;
		}

	
}
