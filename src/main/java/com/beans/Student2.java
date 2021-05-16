package com.beans;

import java.io.Serializable;
import java.util.Date;

public class Student2 implements Serializable {
	public long student_id;
	public long exam_center_id;
	public String subject;
	public long score,year,quarter;
	public String grade;
	
	public Student2() {}
	
	public Student2(long student_id, long exam_center_id, String subject, long score, long year, long quarter,
			String grade) {
		super();
		this.student_id = student_id;
		this.exam_center_id = exam_center_id;
		this.subject = subject;
		this.score = score;
		this.year = year;
		this.quarter = quarter;
		this.grade = grade;
	}
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public long getExam_center_id() {
		return exam_center_id;
	}
	@Override
	public String toString() {
		return "Student2 [student_id=" + student_id + ", exam_center_id=" + exam_center_id + ", subject=" + subject
				+ ", score=" + score + ", year=" + year + ", quarter=" + quarter + ", grade=" + grade + "]";
	}

	public void setExam_center_id(long exam_center_id) {
		this.exam_center_id = exam_center_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getQuarter() {
		return quarter;
	}
	public void setQuarter(long quarter) {
		this.quarter = quarter;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

 

   
  }