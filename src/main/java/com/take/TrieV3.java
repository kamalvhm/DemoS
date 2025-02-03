package com.take;

public class TrieV3 {

	
	
	public static String completeString(int n, String[] a) {
		Trie trie = new Trie();
		for (String word : a) {
			trie.insert(word);
		}

		String longest = "";
		for (String word : a) {
			if (trie.checkIfPrefixExists(word)) {
				if (word.length() > longest.length()) {
					longest = word;
				} else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
					longest = word;
				}
			}
		}
		if (longest.length() == 0)
			return "None";
		return longest;

	}

	static class Trie {
		Node root;

		Trie() {
			root = new Node();
		}

		public void insert(String word) {
			Node node = root;
			for (char ch : word.toCharArray()) {
				if (node.containsKey(ch) == false) {
					node.put(ch, new Node());
				}
				node = node.get(ch);
			}
			node.setEnd();
		}

		public boolean checkIfPrefixExists(String word) {
			Node node = root;
			boolean flag = true;
			for (char ch : word.toCharArray()) {
				if (node.containsKey(ch)) {
					node = node.get(ch);
					flag = flag & node.isEnd();
				} else
					return false;
			}
			return flag;
		}
	}

		static class Node {
			Node links[] = new Node[26];
			boolean flag;

			Node() {
			}

			public boolean containsKey(char ch) {
				return links[ch - 'a'] != null;
			}

			public void put(char ch, Node node) {
				links[ch - 'a'] = node;
			}

			public Node get(char ch) {
				return links[ch - 'a'];
			}

			public void setEnd() {
				flag = true;
			}

			public boolean isEnd() {
				return flag;
			}
		}
	
	public static void main(String[] args) {
		
	}
}
