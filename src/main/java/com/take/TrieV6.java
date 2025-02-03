package com.take;

import java.util.*;

public class TrieV6 {
	
//https://www.naukri.com/code360/problems/maximum-xor_973113
	public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries=new ArrayList<>();
        int m=queries.size();
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);
            offlineQueries.add(temp); 
        }
        Collections.sort(offlineQueries,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind=0;
        int n=arr.size();
        Trie3 trie=new Trie3();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<m;i++)ans.add(-1);
        for(int i=0;i<m;i++){
            while(ind<n && arr.get(ind)<=offlineQueries.get(i).get(0)){
                trie.insert(arr.get(ind));
                ind++;
            }
            int queryInd=offlineQueries.get(i).get(2);
            if(ind!=0)ans.set(queryInd,trie.getMax(offlineQueries.get(i).get(1)));
            else ans.set(queryInd,-1);
            
        }
        return ans;
    }


   static class Node3{
		Node3[] links=new Node3[2];
		public boolean containsKey(int ind){
			return (links[ind]!=null);
		}
		Node3 get(int ind){
			return links[ind];  
		}
		void put(int ind,Node3 node){
			links[ind]=node;
		}
	}
	static class Trie3{
		private Node3 root;
		Trie3(){root=new Node3();}

		public void insert(int num){
			Node3 node=root;
			for(int i=31;i>=0;i--){
				int bit=(num>>i) & 1;
				if(!node.containsKey(bit)){
					node.put(bit,new Node3());
				}
				node=node.get(bit);
			}
		}
		public int getMax(int num){
			Node3 node=root;
			int maxNum=0;
			for(int i=31;i>=0;i--){
				int bit=(num>>i) & 1;
				if(node.containsKey(1-bit)){ // this will toggle (opposite) bit as we have single bit
					maxNum=maxNum | (1<<i);  //set ith bit as its possible
					node=node.get(1-bit);	//move node
				}else {
					node=node.get(bit); //not possible so keep default 0
				}
			}
			return maxNum;
		}
	}
	
}

