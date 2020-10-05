package com.trash.t2;

public interface A {
	
	void changeGear() ;
	
	abstract void printstatus();
	public static void  stMethod() {
		System.out.println("STSTIC METHOD");
	}
	
	default void DefMethod() {
		System.out.println("DEFAULT METHOD");
	}
	
	
	
}
