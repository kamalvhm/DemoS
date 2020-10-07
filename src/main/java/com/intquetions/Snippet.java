package com.intquetions;

import java.util.ArrayList;
import java.util.List;

public class Snippet {
  static List<String> valid_par=new ArrayList<>();

   public static List<String> generateParenthesis(int n) {
          add_par("", n, 0);
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
      
      
      public static void main(String args[]) {
        generateParenthesis(2);
      }
      
}

