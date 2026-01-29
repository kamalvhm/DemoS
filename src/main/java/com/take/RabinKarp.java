package com.take;

public class RabinKarp {
	private  final int PRIME =101; 
	
	//intial mathod to calculate hash
	private double calculateHash(String str) {
		double hash=0;
		
		for(int i=0;i<str.length();i++) {
			hash= hash + str.charAt(i) * Math.pow(PRIME, i);
		}
		return hash;
	}
	
	//To get rolling hash 
	private double updateHash(double prevHash,char oldChar,char newChar,int patternLength) {
		double newHash=(prevHash-oldChar)/PRIME; //remove older char from hash
		newHash=newHash+newChar*Math.pow(PRIME, patternLength-1); //add new Char in hash
		return newHash;
	}
	
	
	//Main algo Rabin karp
	public void search(String text,String pattern) {
		int patternLength=pattern.length();
		
		double patternHash=calculateHash(pattern);
		double textHash=calculateHash(text.substring(0,patternLength));
	
		for(int i=0;i<=text.length()-patternLength;i++) {
			if(textHash==patternHash) {
				if(text.substring(i,i+patternLength).equals(pattern)) {
					System.out.println("Pattern found at "+i);
				}
			}
			
			
			if(i<text.length()-patternLength) {
				textHash=updateHash(textHash, text.charAt(i),text.charAt(i+patternLength) , patternLength);
			}
		}
	
	}
	
	
	public static void main(String args[]) {
		RabinKarp rk=new RabinKarp();
		rk.search("sadkamalsdad","kamal");
	}
}
