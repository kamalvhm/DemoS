package com.datastructure;

import java.util.EmptyStackException;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 1) stack is used to find desired string combination for example 'ab' if peek ==current then pop other wise push into stack check maximumGain()
 * 2) stack is used to find next smaller just maintain increasing sequence in stack largestRectangleArea();
 * 
 *
 * 
 */

public class Stack<T> implements Iterable<T> {

	private LinkedList<T> list =new LinkedList<>();

	public Stack(){}
	
	public Stack(T firstElem){
		push(firstElem);
	}
	
	public int size() {
		return list.size();
	}

	public void push(T firstElem) {
		list.addFirst(firstElem);
	}
	
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return list.removeFirst();
	}
	
	public T peek() {
		if(isEmpty())throw new EmptyStackException();
		return list.peekLast();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	

	@Override
	public Iterator iterator() {
		return list.iterator();
	}

	
	public static void main(String args[]) {
		//Errichto Live for 84 . problem No with https://www.youtube.com/watch?v=SSpnMY5TrTw
		int[] a ={ 2,1,5,6,2,3};
		System.out.print(largestRectangleArea(a));
	}
	
	   //84. Largest Rectangle in Histogram || discussion https://www.youtube.com/watch?v=SSpnMY5TrTw || 
	
    //// https://www.youtube.com/watch?v=NFGteS5mnc0&feature=youtu.be  //IMP CONCEPT OF FINDING MINIMUM AND MXIMUM
  public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Stack<Integer> stack = new java.util.Stack<>();  
        //using the stack to find the last number which smaller than heights[i]
        for(int i=0; i<n; i++) { //we are keeping increaing sequence only in stack 
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        //using the stack to find the next number which smaller than heights[i]
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }


        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
  
  
  //1717. Maximum Score From Removing Substrings
  public int maximumGain(String s, int x, int y) {
      char first = x > y ? 'a' : 'b', secound = x > y ? 'b' : 'a';
		int max = Math.max(x, y), min = Math.min(x, y);
		int res = 0;
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == first && c == secound) { //COmpare Peek and current if so pop other wise push
				stack.pop();
				res += max;
			} else
				stack.push(c);
		}
		// Now we are iterating stack so string will become reversed , we look for ba not
		// in actual string
		Stack<Character> stack2 = new Stack<>();
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (!stack2.isEmpty() && stack2.peek() == first && c == secound) {
				stack2.pop();
				res += min;
			} else
				stack2.push(c);
		}
		return res;
   }
   //856. Score of Parentheses
  public int scoreOfParentheses(String s) {
      Stack<String> st =new Stack<>();
          
      for(int i=0;i<s.length();i++){
          char c =s.charAt(i);
          if(s.isEmpty())
              st.push(c+"");
          else {
              if(c==')'){
                  int innerScore=0;
                  while(!st.isEmpty() && !st.peek().equals("("))
                      innerScore+=Integer.valueOf(st.pop());
                  st.pop();
                  
                  if(innerScore==0)
                      st.push("1");
                  else
                      st.push(2*innerScore+"");
              }else st.push(c+"");
          }
      }
      int score=0;
      while(!st.isEmpty())
          score+=Integer.valueOf(st.pop());
      return score;
  }
  //946. Validate Stack Sequences
  public boolean validateStackSequences(int[] pushed, int[] popped) {
      Stack<Integer> st =new Stack<>();
      int i=0,n=pushed.length;
      for(int num:pushed){
          st.push(num);
          
         while(!st.isEmpty() && st.peek()==popped[i]){
             st.pop();
             ++i;
         }
      }
     
      return (i==n);
  }
}
