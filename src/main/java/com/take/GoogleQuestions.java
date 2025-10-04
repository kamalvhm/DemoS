package com.take;

import java.time.LocalDate;
import java.time.MonthDay;

public class GoogleQuestions {
	//i) First round was code and entry system where event is id,entry()true/false and time need to tell at any moment cound of max persons in building 
	//ii) BS question
	//3) encode and decode a graph check GraphCodec.java in com.graph 
	
/** 4) Design an algorithm to manage birthday reminders for your family tree. You are given a genealogical tree representing your direct ancestors, rooted at you. 
	Each person in the tree has a name and birthday. Your task is to implement a function) that sets an alarm for the next upcoming birthday in the family tree. 
	After that birthday passes, alarmNextBirthday() should be called again to set an alarm for the subsequent upcoming birthday, and so on.
	*/
	public static void main(String[] args) {
		 	Person me = new Person("Me", MonthDay.of(6, 15));
	        Person dad = new Person("Dad", MonthDay.of(5, 10));
	        Person mom = new Person("Mom", MonthDay.of(7, 20));
	        Person grandpa = new Person("Grandpa", MonthDay.of(4, 5));
	        Person grandma = new Person("Grandma", MonthDay.of(8, 25));

	        me.addAncestor(dad);
	        me.addAncestor(mom);
	        dad.addAncestor(grandpa);
	        dad.addAncestor(grandma);

	        BirthdayReminder reminder = new BirthdayReminder(me);

	        Person nextBirthdayPerson = reminder.alarmNextBirthday();
	        System.out.println("Next upcoming birthday: " + nextBirthdayPerson.name + " on " + 
	            reminder.getNextBirthdayDate(nextBirthdayPerson.birthday, LocalDate.now()));
	}

}
