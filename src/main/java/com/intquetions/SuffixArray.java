package com.intquetions;

import java.util.ArrayList;
import java.util.List;

/**
 * Think about the fact that the last substring's initial must be the largest
 * letters in the input string. So we are going to create a suffix array only
 * begins with the largest letter, then use bubble sort to find the largest one.
 * We will create a Suffix class to avoid redundent substring() operation and
 * reducing memory occupation, because if Suffix objects only store pointers.
 * 
 * To avoid the worest case, we will also check if all the letters are the same.
 * This give us the chance to early quit and avoid TLE.
 */

class SuffixArray {
	class Suffix implements Comparable<Suffix> {
		String str;
		int index;

		public Suffix(String _str, int _index) {
			str = _str;
			index = _index;
		}

		public int length() {
			return str.length() - index;
		}

		public int compareTo(Suffix other) {
			for (int i = 0; i < this.length() && i < other.length(); i++) {
				char charThis = this.str.charAt(this.index + i);
				char charOther = other.str.charAt(other.index + i);
				if (charThis != charOther) {
					return charThis - charOther;
				}
			}
			return this.length() - other.length();
		}

		public String toString() {
			return str.substring(index);
		}
	}

	public String lastSubstring(String s) {
		List<Integer> largestLetterIndex = new ArrayList<>();
		char largestLetter = 'a';

		// let's first find the largest letter in the input string and their indexes
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > largestLetter) {
				largestLetterIndex.clear();
				largestLetter = s.charAt(i);
			}
			if (s.charAt(i) == largestLetter) {
				largestLetterIndex.add(i);
			}
		}

		// if the count of indexes we've collected is as many as the input string's
		// length, this means all the letters are the same, so the last substring is the
		// string itself.
		if (largestLetterIndex.size() == s.length())
			return s;

		// now create suffix begins from all the largest letters
		Suffix[] suffixes = new Suffix[largestLetterIndex.size()];
		for (int i = 0; i < suffixes.length; i++) {
			suffixes[i] = new Suffix(s, largestLetterIndex.get(i));
		}

		// using the idea of bubble sort, scan once. The last element is the largest
		// suffix, or our target
		for (int i = 0; i < suffixes.length - 1; i++) {
			if (suffixes[i].compareTo(suffixes[i + 1]) > 0) {
				Suffix temp = suffixes[i];
				suffixes[i] = suffixes[i + 1];
				suffixes[i + 1] = temp;
			}
		}
		return suffixes[largestLetterIndex.size() - 1].toString();
	}

	public static void main(String args[]) {
		SuffixArray s = new SuffixArray();
		System.out.print(s.lastSubstring("abab"));

	}
}