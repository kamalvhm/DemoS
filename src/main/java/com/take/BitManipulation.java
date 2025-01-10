package com.take;

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


	}
	
	private static List<List<Integer>> powerSet(int[] a) {
		int n=a.length;
		int totalNoSubsets=1<<n; //2 power n by left shif
		List<List<Integer>> ans=new ArrayList<>();
		for(int num=0;num<=totalNoSubsets-1;num++) {  //iterating all decimal numbers
			List<Integer> subset=new ArrayList<>();
			for(int i=0;i<n;i++) { //check bits set or not one by one
				if((num&(1<<i))!=0)subset.add(a[i]);
			}
			ans.add(subset);
		}
		return ans;
	}

	private static int noOfBitsFlip(int start, int goal) {
		int ans=start^goal;
		//return noOfSetBits(ans); or 
		int cnt=0;
		for(int i=0;i<=31;i++) {  //as input is interger
			if((ans & (1<<i))!=0)cnt++;  //count ith bit is set or not
		}
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
