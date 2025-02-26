package com.datastructure;

public class BitWiseOperator {
	//Practice:-https://leetcode.com/problems/add-binary/
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
		
		//rightShift zero fill operator >>>  IMP Check hammingWeight example 
		int rightShiftZeroFill= a>>>2;
		
		System.out.println("AND "+and+" Bineary "+Integer.toBinaryString(and));
		System.out.println("OR "+or+" Bineary "+Integer.toBinaryString(or));
		System.out.println("XOR "+xor+" Bineary "+Integer.toBinaryString(xor) );
		System.out.println("comp "+comp+" Bineary "+Integer.toBinaryString(comp));
		System.out.println("leftshift "+leftshift+" Bineary "+Integer.toBinaryString(leftshift));
		System.out.println("rightshift "+rightshift+" Bineary "+Integer.toBinaryString(rightshift));
		System.out.println("rightShiftZeroFill "+rightShiftZeroFill+" Bineary "+Integer.toBinaryString(rightShiftZeroFill));

		hasAlternatingBits(2);
		
		 int xor1=4;//100
		 int set_bit_no;

	     /* Get the rightmost set bit in set_bit_no */
		 set_bit_no = xor1 & ~(xor1 - 1);
		 System.out.print("RIGHT MOST "+set_bit_no);
		 
		 
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
		 //1101
         while(n != 0 && (n >> 1) != 0){
            if(((n & 1) ^ ((n >> 1) & 1)) == 0) return false;  // (n & 1) this means 110(1) this bit and after this(n >> 1) 110 will left
            n = n >> 1;
        } return true;
    }
	 //Sudo code ONLY
	 public static boolean hasAlternatingBits3(int n) {
         //1101
		//to check the previous bit first bit from right 110(1)this we can & it with one so and will give 1 if only its one 
		 
		 //to check previousbit =1 (num&1)
		 //num >> =1 after this shift bit will become 110
		// no check present bit 110 & 1 is 0 then is ok because previous was 1 and this was 0 so shift no 
		 //other wise return false 
		return false ;
		 
    }
	 
	 boolean hasAlternatingBits4(int n){
		    while(n != 0) //while(n)
		    {
		        if((n & 3) == 0 || (n & 3) == 3)
		        {
		            return false;
		        }
		        
		        n >>= 1; //to check one bit at time shifting to right for example after shift 1101 will become 110
		    }
		    
		    return true;
		}
	 
	 //191 Number of 1 Bits | https://www.youtube.com/watch?v=pAN7bz5dMxo
	 public int hammingWeight(int n) {
	        int count=0;
	        while(n!=0){
	            //n%2 will give last bit to check use & 1
	            count+=(n%2) & 1;
	            //>> shift oprator on negative (signed) adds 1 at right istead of zero  so use >>> instead this will
	            // use 0 in LSB instead of one
	            n>>>=1; 
	        }
	        return count;
	    }
	 
	 
	 // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
	    public int hammingDistance(int x, int y) {
	        int results=0;
	        while(x>0 || y>0){
	            results+=(x%2)^(y%2);
	            x>>=1;
	            y>>=1; //shift 1 bit
	        }
	        return results;
	    }
}
