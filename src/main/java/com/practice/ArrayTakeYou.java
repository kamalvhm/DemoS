package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayTakeYou {

	public static void main(String[] args) {
		
		int [] qA1= {1,2,4,7,7,5}; 
		System.out.println("1) Secound largest element without sort [5] :- "+secoundLargest(qA1));
		
		System.out.println("2) is Array sorted [false] :- "+isSorted(qA1));
		
		int [] qA2= {1,1,2,2,3,3}; 
		System.out.print("3) Remove duplicate from "+Arrays.toString(qA2)+" sorted array [3] :- "+removeDuplicate(qA2));
		System.out.println(" Array Now:- "+Arrays.toString(qA2));	
		
		int [] qA4= {1,2,3,4}; //For Right Rotation check leet code question https://leetcode.com/problems/rotate-array/
		System.out.print("4) Left Rotate "+Arrays.toString(qA4)+" Array  [3,4,1,2] :- ");
		rotate(qA4,2);
		System.out.println(" Array Now:- "+Arrays.toString(qA4));
		
		int [] qA5= {1,2,0,0,3,4}; 
		System.out.print("5) Moving zeros to end of "+Arrays.toString(qA5)+" array  [1,2,3,4,0,0] :- ");
		moveZeros(qA5);
		System.out.println(" Array Now:- "+Arrays.toString(qA5));
		
		
		int [] qA61= {1,3,5};  int [] qA62= {2,4};
		System.out.print("6) Union of Arrays  [1,2,3][4,5] :- ");
		unionTwoArray(qA61,qA62);
		int [] qA71= {1,3,5};  int [] qA72= {3,5,6};
		System.out.print("BSS:- "+bs(qA72,3));
		System.out.print("7) IntegerSection (common in both)  [3,5] :- ");
		intersectionTwoArray(qA71,qA72);
		
		int [] qA8= {3,0,1};
		System.out.print("8) Missing No  [2] :- "+missingNo(qA8));
		
		int [] qA9= {1,1,0,1,1,1};
		System.out.print("9) Count Max no of 1s  [3] :- "+ConsecutiveOnce(qA9));
		
		int [] qA10= {1,1,2,3,3,2,5};
		System.out.print("10) Find No Apear once in array [5] :- "+noApearOnce(qA10));
	}

	private static int noApearOnce(int[] a) {
		int xor=0;
		for(int i:a)
			xor^=i;
		return xor;
	}

	private static int ConsecutiveOnce(int[] a) {
		int max=0,count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==1)count++;
			max=Math.max(max, count);
			if(a[i]==0)count=0;
		}
		return max;
	}

	
	private static int missingNo(int[] a) {
	   int n=a.length;
//	        int sum=(n*(n+1))/2;
//	        int arrSum=0;
//	        for(int i=0;i<a.length;i++)
//	            arrSum+=a[i];
//	        return Math.abs(sum-arrSum);
		int xor1=0,xor2=0;
		for(int i=0;i<a.length;i++) {
			xor2^=a[i];
			xor1^=(i+1);
		}
		return xor1^xor2;
	}
	

	private static void intersectionTwoArray(int[] a, int[] b) {
		
		ArrayList<Integer> intersection=new ArrayList<>();
		boolean []visited=new boolean[b.length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j] && visited[j]==false) {
					intersection.add(a[i]);
					visited[j]=true;
					break;
				}
				if(b[j]>a[i])break;
			}
			
		}
 //USING Binery Search
//		boolean []visited=new boolean[b.length];
//		for(int i=0;i<a.length;i++) {
//			int found=bs(b,a[i]);
//			if(found!=-1 && visited[found]==false) {
//				intersection.add(a[i]);
//				visited[found]=true;
//			}
//			
//		}
		
		System.out.println(intersection);
		
	}
	
	public static int bs(int a[],int target) {
		int l=0,r=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]==target)return mid;
			else if(a[mid]<target)
				l=mid+1;
			else r=mid-1;
		}
		return -1;
	}


	private static void unionTwoArray(int[] a, int[] b) {
		ArrayList<Integer> union=new ArrayList<>();
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				if(union.isEmpty() || union.get(union.size()-1)!=a[i])
					union.add(a[i]);
				i++;
			} else {
				if(union.isEmpty() || union.get(union.size()-1)!=b[j])
					union.add(b[j]);
				j++;
			}
		}
		while(i<a.length) {
			if(union.isEmpty() || union.get(union.size()-1)!=a[i])
				union.add(a[i]);
			i++;
		}
		while(j<b.length) {
			if(union.isEmpty() || union.get(union.size()-1)!=b[j])
				union.add(b[j]);
			j++;
		}
		System.out.println(union);
	}

	
	private static void moveZeros(int[] a) {
		int n=a.length;
		int j=-1;
		for(int i=0;i<n;i++) {
			if(a[i]==0) {
				j=i;
				break;
			}
		}
		if(j==-1)return; 
		for(int i=j+1;i<n;i++) {
			if(a[i]!=0)
				swap(a,i,j++);
		}
		
	}
	
	private static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j]; 
		a[j]=temp;
	} 

	private static void rotate(int[] a,int k) {
//		int temp=a[0]; //if one place
		int n=a.length;
//		for(int i=1;i<n;i++)
//			a[i-1]=a[i];
//		a[n-1]=temp;
		if(k>n)k=k%n;
		int temp[]=new int[k];
//		for(int i=0;i<k;i++)  //left rotation brute
//			temp[i]=a[i];
//		for(int i=k;i<n;i++)
//			a[i-k]=a[i];
//		int j=0;
//		for(int i=n-k;i<n;i++)
//			a[i]=temp[i-(n-k)];
//		for(int i=n-k;i<n;i++) //right rotation
//			temp[i-(n-k)]=a[i];
//		for(int i=n-k-1;i>=0;i--)
//			a[i+k]=a[i];
//		for(int i=0;i<k;i++)
//			a[i]=temp[i];
		
		reverse(a,0,k-1);
		reverse(a, k, n-1);
		reverse(a, 0, n-1);
	}
	
	private static void reverse(int a[],int i,int j) {
		while(i<j) {
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
			j--;
		}
	}

	private static int removeDuplicate(int[] a) {
//		HashSet<Integer> hs=new HashSet<>();
//		for(int i:a)
//			hs.add(i);
//		int index=0;
//		for(int i:hs)
//			a[index++]=i;
//		return index;
		int i=0;
		for(int j=1;j<a.length;j++) {
			if(a[i]!=a[j]) {
				a[i+1]=a[j];
				i++;
			}
		}
		return i;
		
	}

	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(i>0 && a[i]<a[i-1])return false;
		}
		return true;
	}

	public static int secoundLargest(int[] arr) {
        int largest=arr[0],seound=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
            	seound=largest;
                largest=arr[i];
            }
            else if(arr[i]>seound && arr[i]!=largest){
            	seound=arr[i];
            } 
        }
        return seound;
    }

}
