package com.intquetions;
public class RemoveDuplicate {

 

  public static void main(String[] args) {

    String inputString = "abbbccccbb";
    int k = 4;
    String str = process(inputString, k);
    System.out.println(str);
  }

 

  private static String process(String inputString, int k) {
    String returnedString = inputString;
    do {
      inputString = returnedString;
      returnedString = removeDuplicate(inputString, k);
    } while(!inputString.equals(returnedString));
    return returnedString;
  }

 

  private static String removeDuplicate(String inputString, int k) {
      if(inputString.length() < k )
        return inputString;
     String str = inputString;
     int count = 1;
     int startIndex =  0;
     for(int i=0;i< inputString.length()-1; i++) {
       if(inputString.charAt(i) == inputString.charAt(i+1)) {
         count++;
         if(startIndex == 0)
           startIndex = i;
       } else if(count >= k){
         break;
       } else {
         count = 1;
         startIndex = 0;
       }
       
     }
     System.out.println("count:"+count+" index:"+startIndex);
     if(count >= k) {
       str = inputString.substring(0,startIndex)+inputString.substring(startIndex+count);
     }
     System.out.println("return : "+str);
     return str;
  }

 

}