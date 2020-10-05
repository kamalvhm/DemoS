package com.studyfromDocs;

import java.util.Arrays;

public class Pitho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
		for(int i:pithoTriplet(a)) {
			System.out.println(i);
		}*/
		
		String s[] = {"proback","proback"};
		longestCommonPrefix(s);
		
		
		
	}
	
	
	 public static String longestCommonPrefix(String[] strs) {
         if(strs.length == 0)
            return new String();
        Arrays.sort(strs);
        String str = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        for( i = 1; i < str.length()+1; ++i ){
            if( !str.startsWith(end.substring(0,i)))
                break;
        }
        return end.substring(0,i-1);
        
        
    }
	
	public static int[] pithoTriplet(int a[]) {
		int n=a.length;
		int [] out=new int [n+1];
		int index=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int x = sqr(a[i]); int y=sqr(a[j]); int z=sqr(a[k]);
					if(x+y==z||z+y==x||x+z==y) {
						out[index++]=a[i];
						out[index++]=a[j];
						out[index++]=a[k];
					}
				}
			}
		}
		return out;
	}
	
	
	public static int sqr(int i) {
		return i*i;
	}

}
