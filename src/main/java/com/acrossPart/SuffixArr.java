package com.acrossPart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.graph.BellmanFordAdjacencyList.Edge;

public class SuffixArr {
class Suffix implements Comparable<Suffix>{
	String s;
	public int index;
	
	Suffix(String s,int index){
		this.s=s;
		this.index=index;
	}
	int length() {
		return s.length()- index;
	}
	
	
	public int compareTo(Suffix o) {
		for(int i=0;i<s.length() && i<o.length();i++) {
			char chr=this.s.charAt(this.index+i);
			char otrChar=o.s.charAt(o.index+i);
			
			if(chr!=otrChar)
				return chr-otrChar;
		}
		return this.length()-o.length();
	}
	
	
	@Override
	public String toString() {
		return s.substring(index);
	}
}	
	public String getLast(String s) {
		List<Integer> lastindexes=new ArrayList<Integer>();
		char largestLetter='a';
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>largestLetter) {
				lastindexes.clear();
				largestLetter=s.charAt(i);
			}
			
			if(s.charAt(i)==largestLetter)
				lastindexes.add(i);
		}
		
		Suffix[] sfx=new Suffix[lastindexes.size()];
		for(int i=0;i<lastindexes.size();i++) {
			sfx[i]=new Suffix(s,lastindexes.get(i));
		}
		
		for(int i=0;i<sfx.length-1;i++) {
			if((sfx[i].compareTo(sfx[i+1]))>0) {
				Suffix tmp=sfx[i];
				sfx[i]=sfx[i+1];
				sfx[i+1]=tmp;
			}
		}
		return sfx[lastindexes.size()-1].toString();
	}





public static void main(String asgr[]) {
	SuffixArr s = new SuffixArr();
	System.out.print(s.getLast("abab"));

}



}
