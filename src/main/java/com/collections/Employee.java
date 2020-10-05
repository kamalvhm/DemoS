package com.collections;

public class Employee  implements Comparable<Employee>{
	String name;
	int id;
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Employee o) {
		int id1=this.id;
		int id2=o.id;
		if(id1<id2)return -1;
		if(id1>id2) return +1;
		return 0;
	}

}
