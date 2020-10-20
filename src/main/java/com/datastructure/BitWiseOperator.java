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
		
		System.out.println("AND "+and+" Bineary "+Integer.toBinaryString(and));
		System.out.println("OR "+or+" Bineary "+Integer.toBinaryString(or));
		System.out.println("XOR "+xor+" Bineary "+Integer.toBinaryString(xor) );
		System.out.println("comp "+comp+" Bineary "+Integer.toBinaryString(comp));
		System.out.println("leftshift "+leftshift+" Bineary "+Integer.toBinaryString(leftshift));
		System.out.println("rightshift "+rightshift+" Bineary "+Integer.toBinaryString(rightshift));
		System.out.println("rightShiftZeroFill "+rightShiftZeroFill+" Bineary "+Integer.toBinaryString(rightShiftZeroFill));

		hasAlternatingBits(2);
	}
	//693. Binary Number with Alternating Bits  
	/**101010101010
	// after shift:
	010101010101
	// XOR
	111111111111
	calculate the efficient bit width of n
	check if n XOR (n>>1) equals to pow(2, bitWidth)-1
	Notice that the result of 1<<bitWidth may overflow, I just ignored it, as the int type in golang is 8 bytes,
	*/
	 public static boolean hasAlternatingBits(int n) {       //!!!!!NOT WORKING!!!!!
		 //This is to get bit length of input  n = 5 for this it will give 3
	        int l=(int)Math.ceil(Math.log(n) / Math.log(2));
	        //creating l length all 1s binary 
	        int bit=(int) (Math.pow(2, l));
	        
	        int a=n>>1;
	        return (a^n)==bit;
	    }

	 
	 public static boolean hasAlternatingBits2(int n) {
         while(n != 0 && (n >> 1) != 0){
            if(((n & 1) ^ ((n >> 1) & 1)) == 0) return false;
            n = n >> 1;
        } return true;
    }
}
