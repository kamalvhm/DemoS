package com.datastructure;

public class BitWiseOperator {

	public static void main(String[] args) {
		int a=15;  //0000 1111
		int b=27;  //0001 1011
		
		
		//Binary AnD Operator (&)
		int and = a&b;
		//Binary OR Operator (|)
		int or =a|b;

		//Binary XOR (^)
		int xor=a^b;

		//Binary One compliment(~)
		int comp=~a;
		
		//left shift >>
		int leftshift= a<<2;  //0011 1100   60
		
		//left shift >>
		int rightshift= a>>2;  //1100 0011 3 withIn limit two bits ignored at front
		
		//rightShift zero fill operator >>> 
		int rightShiftZeroFill= a>>>2;
		
		System.out.println("AND "+and);
		System.out.println("OR "+or);
		System.out.println("XOR "+xor);
		System.out.println("comp "+comp);
		System.out.println("leftshift "+leftshift);
		System.out.println("rightshift "+rightshift);
		System.out.println("rightShiftZeroFill "+rightShiftZeroFill);

		
		
		
	}

}
