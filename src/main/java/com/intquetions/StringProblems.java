package com.intquetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//https://www.youtube.com/watch?v=uq7tbwl6DuM&list=PLt4nG7RVVk1gp0v3wg7gWB26lRzseuHQz
public class StringProblems {
	public static void main(String[] args) {
		String s="ABRACADABRA";
		s.replace("A", "");
		//all sub strings
		for(int i=0;i<s.length();i++) {
			 for (int j =s.length(); j > i; j--) {
				 System.out.println((s.substring(i,j)));
			}
		}

		//convert to ancii
		int ascii = (int) s.charAt(0);
		
		Character.isLetterOrDigit(s.charAt(0));		
		Character.toUpperCase(s.charAt(0));
		
		StringBuffer sb=new StringBuffer();
		//to append in front of String 
		sb.insert(0, "ABC");
		
		
	}
	
	//125. Valid Palindrom
	  public boolean isPalindrome(String str) {
	        int i=0,j=str.length()-1;
	        boolean isPalindrom=false;
	        while(i<j){
	            while(i<j && !Character.isLetterOrDigit(str.charAt(i))){
	                i++;
	            }
	             while(i<j && !Character.isLetterOrDigit(str.charAt(j))){
	                j--;
	            }
	            if(i<j && Character.toLowerCase(str.charAt(i++))!=Character.toLowerCase(str.charAt(j--))){
	               return false;
	            }
	        }
	               return true;
	    }
	  
	  //67. Add Binary
	  public String addBinary(String a, String b) {
	       StringBuilder sb=new StringBuilder();
	        int i=a.length()-1;
	        int j=b.length()-1;
	        int carry=0;
	        while(i>=0 || j>=0){
	            int sum=carry;
	            if(i>=0){
	                sum+=a.charAt(i--) -'0';
	            }
	            
	             if(j>=0){
	                sum+=b.charAt(j--) -'0';
	            }
	             //we are inserting at zero position
	            sb.insert(0,sum % 2);
	            carry =sum/2;
	        }
	        if(carry>0)
	            sb.insert(0,1);
	        
	        return sb.toString();
	    }
	  
	  //415. Add Strings numbers
	   public String addStrings(String num1, String num2) {
	        int carry=0;
	        StringBuilder sb=new StringBuilder();
	        int i=num1.length()-1;
	        int j=num2.length()-1;
	        
	        while(i>=0 || j>=0 ){
	            int sum=carry;
	            
	            if(i>=0){
	                sum+=num1.charAt(i--)-'0';
	            }
	            if(j>=0){
	                sum+=num2.charAt(j--)-'0';
	            }
	            
	            sb.append(sum%10);
	            carry=sum/10;
	        }
	        if(carry>0)
	            sb.append(carry);
	        
	        return sb.reverse().toString();
	        
	    }
	   //  49. Group Anagrams 
	   public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>>  groupAnagrams =new ArrayList<List<String>>();
	        HashMap<String,List<String>> map=new HashMap<>();
	        
	        for(String s:strs){
	            char[] characters=s.toCharArray();
	            Arrays.sort(characters);
	            String sorted=new String(characters);
	            
	            if(!map.containsKey(sorted)){
	                map.put(sorted, new ArrayList());
	            }
	             
	           map.get(sorted).add(s);
	            
	        } 
	
	            groupAnagrams.addAll(map.values());
	        
	        
	        return groupAnagrams;
	    }
	   
	   //763. Partition Labels
	    public List<Integer> partitionLabels(String S) {
	        List<Integer> result =new ArrayList<>();
	        int[] lastIndex=new int[26];
	        for(int i=0;i<S.length();i++){
	            lastIndex[S.charAt(i)-'a']=i;
	        }
	        
	        
	        int i=0;
	        while(i<S.length()){
	            int end=lastIndex[S.charAt(i)-'a'];
	            int j=i;
	            while(j!=end){
	                end=Math.max(end,lastIndex[S.charAt(j++)-'a']);  
	            }
	            result.add(j-i+1);
	            i=j+1;
	        }
	        return result;
	        
	    }
	    //1163. Last Substring in Lexicographical Order Also check in SUFIX ARRAY SOLUTION
	    public String lastSubstring(String s) {
	        int len=s.length();
	        int i=1,j=0,k=0;
	        
	        while(i+k<len){
	            //k means the same letters, the longer, the better.
	            if(s.charAt(i+k)==s.charAt(j+k)){
	                k++;
	                continue;
	            }            
	            //if we find a larger one, replace j by current i.
	            if(s.charAt(i+k)>=s.charAt(j+k)){
	                j=i;
	            }            
	            i++;
	            //every time, we should initiate k by 0.
	            k=0;
	        }
	        return s.substring(j);
	    }
	    
	    //1221. Split a String in Balanced Strings
	    public int balancedStringSplit(String s) {
	        int balanceCount=0;
	        int count=0;
	        for(int i=0;i<s.length();i++){
	           char c=s.charAt(i);
	            if(c=='L')
	                count++;
	            else count--;
	            if(count==0)
	            {
	                balanceCount++;
	            }
	        }
	         return balanceCount;
	    }
	    
	    //1309. Decrypt String from Alphabet to Integer Mapping
	    public String freqAlphabets(String s) {
	        StringBuffer sb=new StringBuffer();
	        int r=s.length()-1;
	        while(r>=0){
	            char c =s.charAt(r);
	            if(c=='#'){
	                int cur = (s.charAt(r - 1) - '0')  + (s.charAt(r - 2) - '0') * 10;
	                sb.insert(0,(char)(cur - 1 + 'a'));
	                r=r-3;
	            }else {
	                sb.insert(0,(char)((c - '0') - 1 + 'a'));
	                r--;
	            }
	        }
	        return sb.toString();
	    }
	    
	    //https://www.youtube.com/watch?v=RG5rWV6in38&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=9
	    public static void solve(String unique,HashMap<Character,Integer> map , int idx,boolean[] used,String s1,String s2,String s3) {
	    	if(idx==unique.length()) {
	    		int num1=getNum(s1,map);
	    		int num2=getNum(s2,map);
	    		int num3=getNum(s3,map);
	    		if(num1+num2==num3) {
	    			for(int i=0;i<26;i++) { //to print in alphabetical order 
	    				char c =(char) ('a'+i);
	    				if(map.containsKey(c)) {
	    					System.out.print(c+"-"+map.get(c)+" ");
	    				}
	    			}
	    			System.out.println("");
	    		}
	    		return;
	    	}
	    	
	    	char c =unique.charAt(idx);
	    	for(int i=0;i<10;i++) {
	    		if(used[i]==false) {
	    			used[i]=true;
	    			map.put(c, i);
	    			solve(unique,map,idx+1,used,s1,s2,s3);
	    			used[i]=false;
	    			map.put(c, -1);
	    		}
	    	}
	    	
	    }

		private static int getNum(String s1, HashMap<Character, Integer> map) {
			String val="";
			for(char c :s1.toCharArray())
				val+=map.get(c);
			return Integer.parseInt(val);
		}
		
		
		
}
