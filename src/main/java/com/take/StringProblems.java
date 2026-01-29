package com.take;

import java.util.ArrayList;
import java.util.List;



public class StringProblems {

	public static void main(String[] args) {
		 // Create object of Solution class
		StringProblems sol = new StringProblems();

		String txt="abaasddgcfsdfasgcfxccggfds"; //7,15
		String pat="gcf";
  
        System.out.println("1)  Pattern found using KMP at indices: [7, 15]:-"+sol.kmp(txt, pat));
		
		
		//return count of char needed to be inserted to make string palindrom for example in below we need to insert PS
		System.out.println("2) Make pl (2): "+sol.solveBrute("ROORSP"));
		
		String txt2="cdeabroab",pat2="abcde";//txt2 is a circluar string find if pattern exist in string;
		
		System.out.println("3) circular search (true): "+sol.searchCircular(txt2,pat2));
		
		String a="abcd",b="cdabcdab"; //return how many times string a needs to be repeated just so that string b becomes substring of string a;
		System.out.println("4) Repeated String Match (3): "+sol.repeatStringMatch(a,b));
		

	}
	
	
	 // Function to compute the LPS (Longest Prefix which is also Suffix) array
    public int[] computeLPS(String s) {
    	 int n=s.length();
         if(n==0 || n==1)return new int[] {0};
         int lps[]=new int[n];
         int pre=0,suf=1;
         while(suf<n){
             if(s.charAt(pre)==s.charAt(suf)){ // if both characters are equal
                 lps[suf]=pre+1;
                 pre++;
                 suf++;
             }else {  //both not equal
                 if(pre==0){  // pre is already at zero
                     lps[suf]=0;
                     suf++;
                 }else { //if non zero check previous and goto that index
                     pre=lps[pre-1];
                 }
                 
             }
         }
         return lps;
    }

    // Function to perform KMP pattern searching
    public ArrayList<Integer> kmp(String text, String pattern) {

        // Preprocess the pattern to get LPS array
        int[] lps = computeLPS(pattern);

        // Result list to store indices where pattern is found
        ArrayList<Integer> result = new ArrayList<>();

        // Indices for text and pattern
        int first = 0, second = 0;

        // Traverse the entire text
        while (first < text.length()) {

            // If characters match, increment both pointers
            if (text.charAt(first) == pattern.charAt(second)) {
            	first++;
            	second++;
            }

            // If full pattern matched
            if (second == pattern.length()) {
                result.add(first - second);
                second = lps[second - 1];
            }

            // If mismatch occurs after some matches
            else if (first < text.length() && text.charAt(first) != pattern.charAt(second)) {
                // Use LPS to skip unnecessary comparisons
                if (second == 0) {
                	first++;
                } else {
                	second = lps[second - 1];
                }
            }
        }

        // Return the list of matching indices
        return result;
    }

    public int kmp2(String s,String t){
        int n=s.length(),m=t.length(); 

        int lps[]=computeLPS(t);
        int first=0,second=0;
        while(first<n && second<m){
            if(s.charAt(first)==t.charAt(second)){
                first++;
                second++;
            }else {
                if(second==0)
                    first++;
                else 
                    second=lps[second-1];
            }
        }

        if(second==m)return first-second;
        else return -1;
    }
    
    public  boolean searchInCircular(String a,String b) {
    	String c=a+a;//add twice to make circular
    	return kmp(c,b).size()>0;
    }
    
    private int repeatStringMatch(String a, String b) {
		int cnt=0;
		StringBuffer sb=new StringBuffer();
		while(sb.length()<b.length()) {
			sb.append(a);
			cnt++;
		}
		ArrayList<Integer> check=kmp(sb.toString(),b); 
		if(check.size()==0) {
			cnt++;
			sb.append(a);
			check=kmp(sb.toString(),b);
			if(check.size()==0)return -1;
		}
		return cnt;
	}

	private boolean searchCircular(String txt, String pat) {
		String circular=txt+txt;
		System.out.println(">>"+circular);
		ArrayList<Integer> ans=kmp(circular, pat);
		return ans.size()>0;
	}

	public int solve(String s) {
		StringBuffer sb=new StringBuffer(s);
		String str=s+"$"+sb.reverse().toString();
		int n=str.length(); 
		int lps[]=new int[n];
		int pre=0,suf=1;
		while(suf<n) {
			if(s.charAt(pre)==s.charAt(suf)) {
				lps[suf]=pre+1;
				pre++;
				suf++;
			}else {
				if(pre==0) {
					lps[suf]=0;
					suf++;
				}else 
					pre=lps[pre-1];
			}
		}
		return s.length()-lps[n-1];
	}
	public int solveBrute(String s) {
		int cnt=0;
		int i=0,j=s.length()-1;
		while(i<j) {
			if(!isPalindrom(s,i,j)) {
				cnt++;
				j--;
			}else {
				i++;
				j--;
			}
		}
		return cnt;
	}
	
	public boolean isPalindrom(String s,int i,int j) {
		while(i<j) {
			if(s.charAt(i++)!=s.charAt(j--))return false;
		}
		return true;
	}

	
	/**
	 *   ROBIN KARP ALGO 
	 */
	
	
}
