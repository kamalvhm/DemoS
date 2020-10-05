package com.studyfromDocs;

public class Student  {
	static int x = 28;  
	
	Student(){
		System.out.println("IN");
		x=10;
	}
	
	public static void main(String args[]){  
		//System.out.println("Your first argument is: "+args[0]);  
		Student s=new Student();
		System.out.println(x);
		
		char c =(Character) null;
		//if(c!=null)
				
        
	}
	
	public void changeVal(Integer a) {
		a=a+10;
	}
	
	public void changeVal(Student a) {
		a.x=a.x+10;
	}


}
