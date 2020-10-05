package com.example;

import java.time.ZonedDateTime;

public class Ex {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		Path lib = Files.createTempDirectory("hello world");
//		Path filePath = Paths.get(lib.toString(),  "ct.sym");
//		URI t = filePath.toUri();
//		System.out.println(t);
//		System.out.println(t.getRawPath());
//		URI uri = URI.create("jar:file:" + t.getRawPath());
//		System.out.println(uri);
//		System.out.println(t.getPath());
//		URI uri2 = URI.create("jar:file:" + t.getPath()); // kaboom
//		System.out.println(uri2);
		
		
	   /* Calendar d = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
	       
	        d.set(Calendar.YEAR, 2019);
	        d.set(Calendar.MONTH, Calendar.APRIL);
	        d.set(Calendar.DATE,1);
	        d.set(Calendar.HOUR_OF_DAY,0);
	        d.set(Calendar.MINUTE, 0);
	        d.set(Calendar.SECOND, 0);
	        d.set(Calendar.MILLISECOND, 0);
	        
	        long timeInMillis = d.getTimeInMillis();
	        System.out.print(timeInMillis);*/
		
/*		ZonedDateTime lt  = ZonedDateTime.now(); 

    // print result 
    System.out.println("ZonedDateTime : " + lt); 
    
    System.out.println("ZonedDateTime** : " + lt.minusHours(1)); */

			String s1="Sachin";  
		   String s2="Sachin";  
		   String s3=new String("Sachin");  
		   String s4="Saurav";  
		   System.out.println(s1.equals(s2));
		   System.out.println(s1.equals(s3));  
		   System.out.println(s1.equals(s4));  


	}


}
