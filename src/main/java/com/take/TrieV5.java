package com.take;

import java.util.ArrayList;

public class TrieV5 {
	
//https://www.naukri.com/code360/problems/maximum-xor_973113
	public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) 
	{
	     Trie2 trie=new Trie2(); 
		 for(int i=0;i<n;i++){
			 trie.insert(arr1.get(i));
		 }
		 int max=0;
		 for(int i=0;i<m;i++){
			 max=Math.max(max,trie.getMax(arr2.get(i)));
		 }
		 return max;
	}


	static class Node2{
		Node2[] links=new Node2[2];
		public boolean containsKey(int ind){
			return (links[ind]!=null);
		}
		Node2 get(int ind){
			return links[ind];  
		}
		void put(int ind,Node2 node){
			links[ind]=node;
		}
	}
	static class Trie2{
		private Node2 root;
		Trie2(){root=new Node2();}

		public void insert(int num){
			Node2 node=root;
			for(int i=31;i>=0;i--){
				int bit=(num>>i) & 1;
				if(!node.containsKey(bit)){
					node.put(bit,new Node2());
				}
				node=node.get(bit);
			}
		}
		public int getMax(int num){
			Node2 node=root;
			int maxNum=0;
			for(int i=31;i>=0;i--){
				int bit=(num>>i) & 1;
				if(node.containsKey(1-bit)){ // this will toggle (opposite) bit as we have single bit
					maxNum=maxNum | (1<<i);  //set ith bit as its possible exist in the trie so xor of num and opposite will result set in maxNum
					node=node.get(1-bit);	//move node
				}else {
					node=node.get(bit); //not possible so keep default 0
				}
			}
			return maxNum;
		}
	}
	
}

