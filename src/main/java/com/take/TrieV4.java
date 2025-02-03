package com.take;

public class TrieV4 {
	
	
//https://www.naukri.com/code360/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SUBMISSION	
public static int countDistinctSubstrings(String s) 
	{
		Trie trie=new Trie();
		for(int i=0;i<s.length();i++){
			String remaining=s.substring(i);
			trie.insert(remaining);
		}
		return trie.getDistinctCount()+1;
	}

	// Can be written with Trie class also alternatively 
	public static int countDistinctSubstrings2(String s) {
		Node1 root = new Node1();
		int n = s.length();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			Node1 node = root;
			for (int j = i; j < n; j++) {
				if (!node.containsKey(s.charAt(j))) {
					node.put(s.charAt(j), new Node1());
					cnt++;
				}
				node = node.get(s.charAt(j));
			}
		}
		return cnt + 1;
	}
}
class Trie{
	private Node1 root;
	private int count=0;
	Trie(){root=new Node1();}

	public void insert(String word){
		Node1 node=root;
		for(char ch:word.toCharArray()){
			if(node.containsKey(ch)==false){
				node.put(ch,new Node1());
				count++;
			}
			node=node.get(ch);
		}
	}
	public int getDistinctCount(){return count;}
}
 class Node1{
	private Node1 []links=new Node1[26];
	public boolean containsKey(char ch){return links[ch-'a']!=null;}
	public void put(char ch,Node1 node){links[ch-'a']=node;}
	public Node1 get(char ch){return links[ch-'a'];}
}
