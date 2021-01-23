package com.datastructure;

import java.util.Iterator;
//Growable array
public class Array<T> implements Iterable<T>{

	private T[] arr;
	
	private int len=0; //length user thinks array is 
	
	private int capacity=0;//actual size;
	
	public Array() {this(16);}
	
	
	
	public Array(int capacity) {
		if(capacity<0) throw new IllegalArgumentException("Invalic capacity"+capacity);
		this.capacity=capacity;
		arr=(T[])new Object[capacity];
	}

	public int size() {
		return len;
	}

	@Override
	public Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index=0;
			@Override
			public boolean hasNext() {
				return index<len;
			}

			@Override
			public T next() {
				return arr[index++];
			}
			
		};
	}
	
	public void add(T elem) {
		if(len+1>=capacity) {
			if(capacity==0)capacity=1;
			else capacity*=2;
			T[] new_arr=(T[])new Object[capacity];
			for(int i=0;i<len;i++) 
				new_arr[i]=arr[i];
			arr=new_arr;
		}
		arr[len++]=elem;
	}
	
	
	public static void main(String args[]) {
		
        
        int a[] = {1,2,3};
        System.out.println(a.length);

        
        String sb="words and 987";
        System.out.println(myAtoi(sb));

		/*int[] num1= {1,2};
		int[] num2= {3,4};
		
		int[] arr=mergeArrays(num1,num2);
        
        int length=arr.length;
        double out=0;
        if(length%2==0){
            out=(double)(arr[length/2]+arr[(length/2)-1])/2;
        }else
            out=(double)arr[length/2];*/
        
	}
	
	  public static int[] mergeArrays(int[] num1, int[] num2){
	        int n1=num1.length;
	        int n2=num2.length;
	        int[] mergedArr=new int[n1+n2];
	        
	        int i=0,j=0,k=0;
	        
	        while(i<n1 && j<n2){
	            if(num1[i]<num2[j])
	                mergedArr[k++]=num1[i++];
	            else
	                mergedArr[k++]=num2[j++];
	        }
	        
	        while(i<n1){
	             mergedArr[k++]=num1[i++];
	        }
	        
	        while(j<n2){
	             mergedArr[k++]=num2[j++];
	        }
	        
	        return mergedArr;
	    }
	  
	  
	  public static int  myAtoi(String s) {
		  int result=0;
	       String  sb=s.replace(" ", "");
	        for(int i=0;i<sb.length();i++){
	            int k=isValidInt(sb.charAt(i));
	            if(k!=-1)
	            result=(result+k)*10;
	        }
	        if(sb.startsWith("-")){
	            result=~(result-1);
	        }
	      
	       return result/10; 
	    }
	    
	    public static int isValidInt(Character c){
	        switch(c){
	                case '0' :
	                    return 0;
	                 case '1' :
	                    return 1;
	                 case '2' :
	                    return 2;
	                 case '3' :
	                    return 3;
	                 case '4' :
	                    return 4;
	                 case '5' :
	                    return 5;
	                 case '6' :
	                    return 6;
	                 case '7' :
	                    return 7;
	                 case '8' :
	                    return 8;
	                 case '9' :
	                    return 9;
	                default : return -1;
	        }
	    }

}
