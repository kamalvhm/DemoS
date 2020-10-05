package com.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static String removeDuplicates(String s, int k) {
         StringBuilder sb = new StringBuilder(s);
        
        int opt;

        while (true) {
            opt = 0;

            int end = sb.length()-1,start = end;

            int l = sb.length();
            for(int i = l; i >= 0; i--) {

                if ((end >= 0 && start >= 0) && sb.charAt(end) != sb.charAt(start)) {
                    end = start;
                    start--;
                } else {
                    start--;

                    if (start < -1)
                        break;
                }

                if (end-start == k) {
                    opt++;
                    sb.delete(start+1, end+1);
                    break;
                }
            }

            if (opt == 0) {
                break;
            }
        }


        return sb.toString();
    }
    
    public static void main(String args[]) {
    	//removeDuplicates("acbbc",2);
    	System.out.println(getSomeThing("bab"));
    }
    
    
    public static int getSomeThing(String s) {
    	HashSet<Character> alluniques=new HashSet<Character>();
    	for(char c:s.toCharArray())
    	alluniques.add(c);
    	int count=0;
    	for(int i=0;i<s.length();i++) {
    		String sub=s.substring(i);
    		if(isContainingAll(sub, alluniques))
    			count++;
    	}
    	return count;
    }
    
    public static boolean isContainingAll(String s ,HashSet<Character> all) {
    	HashSet<Character> allclone=(HashSet<Character>) all.clone();
    	for(char c:s.toCharArray()) {
    		if(allclone.contains(c))
    			allclone.remove(c);
    	}
    	return allclone.isEmpty();
    }
    
    
    public static String removeDuplicates2(String s, int k) {
    	Stack<Character> stack =new Stack<Character>(); 
    	Stack<Integer> count =new Stack<Integer>(); 
    	
    	for(Character c:s.toCharArray()) {
    		if(!stack.isEmpty() && stack.peek()==c && count.peek()==k-1) {
    			while(!stack.isEmpty() && stack.peek()==c)
    			stack.pop();
    			count.pop();
    		}else {
    			int temp=1;
    			
    			if(!count.isEmpty() && stack.peek()==c) {
    				temp+=count.pop();
    			}
    			stack.push(c);
    			count.push(temp);
    		}
    	}
    	
    	StringBuffer sb=new StringBuffer();
    	while(!stack.isEmpty())
    		sb.append(stack.pop());

    return sb.reverse().toString();
    
    }
    
}