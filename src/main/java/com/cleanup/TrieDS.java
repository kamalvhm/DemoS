package com.cleanup;
//Simple DFS solution, the trie prevents both looping through the dictionary (bad with a large dictionary) and trying each possible prefix against it (bad when dictionary words are long).

import java.util.ArrayList;
import java.util.List;

//140. Word Break II |https://leetcode.com/problems/word-break-ii/discuss/956808/Java-DFS-with-Trie-(5ms)
public class TrieDS {
	static final char FIRST = 'a';
    static final char LAST = 'z';
    static class Trie {
        Trie[] next = new Trie[LAST - FIRST + 1];
        String word;
        void add(String word, int pos) {
            if (pos == word.length()) {
                this.word = word;
            } else {
                int nextPos = word.charAt(pos) - FIRST;
                if (next[nextPos] == null) next[nextPos] = new Trie();                
                next[nextPos].add(word, pos + 1);
            }
        }
        Trie next(char ch) {
            return next[ch - FIRST];
        }
        boolean isWord() {
            return word != null;
        }
    };
    
    List<String> options(Trie trieRoot, String s, int pos, List<String>[] cache) {
        if (cache[pos] != null) return cache[pos];
        List<String> result = new ArrayList<>();
        int nextPos = pos;
        Trie trie = trieRoot;
        while (trie != null) {
            if (trie.isWord()) {
                if (nextPos == s.length()) {
                    result.add(trie.word);
                } else {
                    List<String> nextWords = options(trieRoot, s, nextPos, cache);
                    for (String s2 : nextWords) {
                        result.add(trie.word + ' ' + s2);
                    }                    
                }
            }
            trie = nextPos < s.length()? trie.next(s.charAt(nextPos++)): null;
        }
        return cache[pos] = result;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.add(word, 0);
        }
        List<String>[] cache = new List[s.length() + 1];
        List<String> result = options(trie, s, 0, cache);
        return result;
    }
}
