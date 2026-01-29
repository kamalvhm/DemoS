package com.practice;


import java.util.ArrayList;
import java.util.List;

public class BitManipulation {

	public static void main(String[] args) {
		
		System.out.println("1) Convert 13 to binary (1101):- "+convertToBinary(13));
		System.out.println("2) Convert 1101 to decimal (13):- "+convertToDecimal(1101+""));
		Integer a=5,b=6;
		System.out.print("3) Swap Two Numbers without third variable:-");
		swapp(a,b);
		System.out.println("4) If 2nd Bit is Set in 13 or not (true):- "+bitSetOrNot(13,2));
		
		System.out.println("5) Set 2nd Bit of 9  (13):- "+setBit(9,2));
		
		System.out.println("6) Clear 2nd Bit of 13  (9):- "+clearBit(13,2));

		System.out.println("7) Toggle 2nd Bit of 13  (9):- "+toggleBit(13,2));

		System.out.println("8) Remove the last set (right most) Bit of 12  (8):- "+removeLastSetBit(12));

		System.out.println("9) No is power of 2 or not  (true):- "+powerOfTwo(16));

		System.out.println("10) Count No. of set Bits in given Number  (3):- "+noOfSetBits(13));

		System.out.println("11) No. of bits need flip to convert start to goal  (3):- "+noOfBitsFlip(10,7));

		System.out.println("12) Generate Power Set for [1,2,3]:- "+powerSet(new int[] {1,2,3}));
		
		int nums[]= {1,2,1,2,4};
		System.out.println("13) Return Single No from input array  (4):- "+singleNoI(nums));
		
		int nums2[]= {1,2,1,2,1,2,4};//every no appears three times except one element 
		System.out.println("14) Return Single No II from input array  (4):- "+singleNoII(nums2));

		int nums3[]= {2,4,2,14,3,7,7,3};//every no appears three times except one element 
		System.out.println("15) Return two Single No III from input array  (14,4):- "+singleNoIII(nums3));
		
		System.out.println("16) Xor for 1 to N (4):- "+xorItoN(4));
		
		System.out.println("17) Xor for Range 4 to 7 & (0):- "+xorRange(4,7));

		System.out.println("18) Divide two No (3):- "+divide(13,4));
		
		String a19="abdc" ,b19 ="bcfda"; //string b contains one extra charater find extra in b
		System.out.println("19) Find Extra character in string b [f]:- "+uniqueChar(a19,b19));


	}
	

	
	private static char  uniqueChar(String a, String b) {
		int xor=0;
		for(char ch:(a+b).toCharArray()) {
			xor^=ch;
		}
		return (char)xor;
	}



	public static int divide(int dividend, int divisor) {
	  if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
	  if(dividend==Integer.MIN_VALUE && divisor==1)return Integer.MIN_VALUE;
	  
	  boolean negative=dividend<0 ^ divisor<0;
	  long absDividend=Math.abs(dividend);
	  long absDivisor=Math.abs(divisor);
	  
	  int quotient=0;
	  while(absDividend>absDivisor) {
		   long tempDivisor=absDivisor,multiplier=1;
		   while(absDividend>tempDivisor<<1) {
			   tempDivisor<<=1;
			   multiplier=multiplier<<1;
		   }
		   absDividend-=tempDivisor;
		   quotient+=multiplier;
	  }
	  return negative?-quotient:quotient;
    } 

	private static int xorRange(int l, int r) {
	    return xorItoN(l-1)^xorItoN(r);

	}

	private static int xorItoN(int n) {
		if(n%4==1)return 1;
		else if(n%4==2)return n+1;
		else if(n%4==3)return 0;
		else 
		return n;
	}

	private static String singleNoIII(int[] nums) {
		int xr=0;
		for(int i:nums)
			xr^=i;
		int rightBit=(xr & xr-1) ^ xr;
		int b1=0,b2=0;
		for(int i=0;i<nums.length;i++) {
			if((nums[i]&rightBit)!=0)b1^=nums[i];
			else b2^=nums[i];
		}
		
		return b1+" "+b2;
	}

	private static int singleNoII(int[] nums) {
		int n=nums.length;
		int once=0,twos=0;
		
		return once;
	}

	private static int singleNoI(int[] nums) {
		int xor=0; 
		
		return xor;
	}

	private static List<List<Integer>> powerSet(int[] a) {
		int n=a.length;
		List<List<Integer>> ans=new ArrayList<>();
			
		return ans;
	}

	private static int noOfBitsFlip(int start, int goal) {
		int noOfBits=start^goal;
		int cnt=0;
		
		return cnt;	
	}

	private static int noOfSetBits(int n) {
/**		int count=0;
		while(n>1) {
			count+=(n&1);//odd check or 'if(n%2==1)cnt++'
			n=n>>1; // doing right shift instead of n=n/2; as its fast
		}
		if(n==1)count++;
		return count;
*/
		int cnt=0;
		while(n!=0) {
			n=(n & n-1); //setting right most bit to 0 at a time and counting
			cnt++;
		}
		return cnt;
	}

	private static boolean powerOfTwo(int N) {
		return ((N & (N-1))==0);
	}

	private static int removeLastSetBit(int n) {
		return (n & (n-1));
	}

	private static int toggleBit(int n, int i) {
		return (n ^ (1 << i));
	}

	private static int clearBit(int n, int i) {
		return (n & (~(1 << i)));
	}

	private static int setBit(int n, int i) {
		return (n | (1 << i));
	}

	private static boolean bitSetOrNot(int n, int i) {
		//return ((n & (1 << i))!=0); or using right shift 
		return (1 & (n >> i))!=0;
	}

	private static void swapp(int a, int b) {
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a="+a+",b="+b);
	}

	private static int convertToDecimal(String str) {
		int num=0,p2=1;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)=='1')num=num+p2;
			p2=p2*2;
		}
		return num;
	}

	public static String convertToBinary(int no) {
		StringBuffer sb=new StringBuffer();
		while(no>0) {
			sb.insert(0,no%2);
			no=no/2;
		}
		//if(no==1)
		//	sb.insert(0, 1);
		return sb.toString();
	}

}
