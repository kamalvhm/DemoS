package com.beans;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String name,subject;
    private int id;
    private int year;
    private int score;
	private String grade;

    public Student(String name, String subject, int id, int year, int score, String grade) {
		super();
		this.name = name;
		this.subject = subject;
		this.id = id;
		this.year = year;
		this.score = score;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

   
  }