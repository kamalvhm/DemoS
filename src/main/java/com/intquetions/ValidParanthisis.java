package com.intquetions;

import java.util.ArrayList;
import java.util.List;
//22. Generate Parentheses    Medium   
public class ValidParanthisis {
  static List<String> valid_par=new ArrayList<>();

   public static List<String> generateParenthesis(int n) {
          //add_par("", n, 0);
	   	  add_par2("", n, n);
          return valid_par;
      }
      
      public static void add_par(String string_par, int close_left, int open_needed){
      
      if(close_left == 0 && open_needed == 0){
         valid_par.add(string_par);
          return;
      }
      
      if(close_left > 0)
          add_par(string_par+"(", close_left-1, open_needed + 1);
      
      if(open_needed > 0)
          add_par(string_par + ")", close_left, open_needed - 1);
      
      return;
  }
      
      //https://www.youtube.com/watch?v=eyCj_u3PoJE
      public static void add_par2(String string_par, int open, int close){
          
          if(open == 0 && close == 0){
             valid_par.add(string_par);
              return;
          }
          
          if(open > 0)
        	  add_par2(string_par+"(", open-1, close);
          
          if(close>open)
        	  add_par2(string_par + ")", open, close - 1);
          
          return;
      }
       
      
      public static void main(String args[]) {
        System.out.print(generateParenthesis(3));
      }
      
}

