package com.trash.t2;
public class SingletonVersionFour {

	private static SingletonVersionFour singletonInstance;
	
	private SingletonVersionFour() { }
	
	public static SingletonVersionFour getInstance() {
		if (singletonInstance == null) {
			synchronized(SingletonVersionFour.class) {
				//Double locking
				if (singletonInstance == null) {
					singletonInstance = new SingletonVersionFour();
				}
			}
		}
		return singletonInstance;
	}
	
	public void singletonMemberMethod() {
		System.out.println("I am a member of the SingletonVersionFour instance !");
	}
}