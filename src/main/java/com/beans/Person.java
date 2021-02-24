package com.beans;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private int age;
    private int id;
	private Date date;

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

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
    
    
    public Date getDate() {
  		return date;
  	}

  	public void setDate(Date date) {
  		this.date = date;
  	}
  }