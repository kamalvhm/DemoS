package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public void left(TreeNode treeNode) {
		// TODO Auto-generated method stub
    	left=treeNode;
		
	}
	public void rigth(TreeNode treeNode) {
		// TODO Auto-generated method stub
		right=treeNode;
	}
	TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Ex {

	public static void main(String[] args) throws Exception{
	
		
		int x=1,y=4;
		System.out.println("XOR "+(x^y));
		
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

			String s1="ABRACADABRA";
	        String str=s1.replace(" ","");

		   /*String s2="Sachin";  
		   String s3=new String("Sachin");  
		   String s4="Saurav";  
		   System.out.println(s1.equals(s2));
		   System.out.println(s1.equals(s3));  
		   System.out.println(s1.equals(s4));  */
			HashSet<String> s=new HashSet<>();
			int count=0;
			for(int i=0;i<s1.length();i++) {
				 for (int j =s1.length(); j > i; j--) {
					 //s2[i]=s1.substring(i,j);
					 s.add(s1.substring(i,j));
					//System.out.println((count++)+" - "+s1.substring(i,j));
				}
			}
			int arr1[]= {1,2,1,3,5,6,4};
			
			//System.out.println(findPeakElement(arr1));
			/*Arrays.sort(s2);
			
			for(String s:s2) {
				System.out.println(s);
			}
			*/
	        
	       
			//int arr[]= {2,2,1};
		
			
			//System.out.println(singleNumber(arr));
			
			//judgeCircle("RRDD");
			
	}
	
	public static boolean judgeCircle(String moves) {
        int R=0,L=0,U=0,D=0;
        for(char c:moves.toCharArray()){
            if(c=='R')
               R++;
             if(c=='L')
               L++;
             if(c=='U')
               U++;
             if(c=='D')
               D++;
            
        }
        return (Math.abs((R-L))+Math.abs((U-D)))==0;
    }
	
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int i=1,j=nums.length-1;
        
        while(i<j){
            if(nums[i-1]!=nums[i]) {
                return nums[i-1];
            }
            else{
                i=i+2;
            }
            if(nums[j-1]!=nums[j]){
                return nums[j];
            }else{
                j=j-2;
            }
            
            
        }
        return 0;
    }
	
	
	
	  public static int longestUnivaluePath(TreeNode root) {
	        if(root==null) return 0;
	        int val1=0,val2=0;   
	        if(root.left!=null && root.left.val==root.val){
	            val1= 1+longestUnivaluePath(root.left);
	        }
	           
	        if(root.right!=null && root.right.val==root.val){
	            val2= 1+longestUnivaluePath(root.right);
	        }
	        
	        int maxVal1=Math.max(val1,val2);
	        int maxVal2=Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right));
	        return Math.max(maxVal1,maxVal2);
	    }
	  
	  //162. Find Peak Element
	  public static int findPeakElement(int[] nums) {
	      int left=0;
	        int right=nums.length-1;
	        
	        while(left<right){
	            int mid=left+(right-left)/2;
	            if(nums[mid]<nums[mid+1])
	                left=mid+1;
	            else 
	                right=mid;
	        }
	        return left;
	    }
	  
	  
	 


}
