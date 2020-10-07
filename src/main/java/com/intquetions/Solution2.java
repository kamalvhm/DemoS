package com.intquetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


class Solution2 {
    static Map<Character,String> m ;
    static List<String > ans ;
    // if digit is '23' in phone then provide all combination of letters ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public static List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0)
            return ans;
        m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        
       
        backtrack(digits,0,new StringBuilder());
        return ans;
    }
    
    
    public static void backtrack(String d,int cur , StringBuilder path)
    {
        if(cur ==d.length()) {
            ans.add(path.toString());
            return ;
        }
        for( int i = 0 ; i < m.get(d.charAt(cur)).length();i++)
        {
            path.append(m.get(d.charAt(cur)).charAt(i));
            backtrack(d,cur+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
    
    public static void main(String args[]) {
      letterCombinations("23");
    }
}