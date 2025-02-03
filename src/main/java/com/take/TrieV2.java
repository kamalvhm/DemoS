package com.take;

class Node{
	Node []links=new Node[26];
	int cntEndsWith=0;
	int cntPrefix=0;
	Node(){}
	public boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}
	public void put(char ch,Node node) {
		links[ch-'a']=node;
	}
	public Node get(char ch) {
		return links[ch-'a'];
	}
	
	public void increaseEnd() {
		cntEndsWith++;
	}
	public void increasePrefix() {
		cntPrefix++; 
	}
	public void deleteEnd() {
		cntEndsWith--;
	}
	public void reducePrefix() {
		cntPrefix--;
	}
	public int getEnd() {return cntEndsWith;}
	public int getPrefix() {return cntPrefix;}
}
public class TrieV2 {
	private static Node root;
	
	TrieV2(){
		root=new Node();
	}
	
	public void insert(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(node.containsKey(ch)==false) {
				node.put(ch, new Node());
			}
			node=node.get(ch);
			node.increasePrefix();
		}
		node.increaseEnd();
	}
	
	public int countWordsEqualsTo(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(node.containsKey(ch)==false)return 0;
			node=node.get(ch);
		} 
		return node.getEnd();
	} 
	public int countWordsStartingWith(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(node.containsKey(ch)) {
				node=node.get(ch);
			}else return 0;
		}
		return node.getPrefix();
	}
	
	public void erase(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(node.containsKey(ch)) {
				node=node.get(ch);
				node.reducePrefix();
			}else return;
		}
		node.deleteEnd();
	}
	public static void main(String[] args) {
		 TrieV2 trie = new TrieV2();
	        trie.insert("apple");
	        trie.insert("app");
	        System.out.println("Inserting strings 'apple', 'app' into Trie");
	        System.out.print("Count Words Equal to 'apple': ");
	        System.out.println(trie.countWordsEqualsTo("apple"));
	        System.out.print("Count Words Starting With 'app': ");
	        System.out.println(trie.countWordsStartingWith("app"));
	        System.out.println("Erasing word 'app' from trie");
	        trie.erase("app");
	        System.out.print("Count Words Equal to 'apple': ");
	        System.out.println(trie.countWordsEqualsTo("apple"));
	        System.out.print("Count Words Starting With 'apple': ");
	        System.out.println(trie.countWordsStartingWith("app"));

	}

}
