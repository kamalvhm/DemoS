package com.backtracking;

public class CrossWord {
   //https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
	public static void main(String[] args) {
		//call :- solution(arr,words,0)
		//LEVEL is Word 
		//OPTION Is place (row and column)  That too for Verical and horizontal 
		//BASE CASE WILL BE ON LEVELS
		
	}
	//https://www.youtube.com/watch?v=fUAZS-sdP2Q&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=8
	public static void solution(char[][] arr,String[] words,int indx) {
		if(indx==words.length) {
			 return;
		}
		String word=words[indx];
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]=='-' || arr[i][j]==word.charAt(0)) {
					if(canPlaceWordHorizontally(arr,word,i,j)) { //can i place my word here 
						boolean [] wePlace=placeWordHorizontally(arr,word,i,j);// if yes then place the word
						solution(arr,words,indx+1); //and call next word 
						uplaceWordHorizontally(arr,wePlace,i,j);// after that unplace 
					}
					
					if(canPlaceWordVertically(arr,word,i,j)) {
						boolean [] wePlace=placeWordVertically(arr,word,i,j);
						solution(arr,words,indx+1);
						uplaceWordVertically(arr,wePlace,i,j);
					}
				}
			}
		}
	}

	

	private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
		boolean wePlaced[] =new boolean[word.length()]; //we are returning this array as in unplace we will remove only that char which we placed 
		for(int ii=0;ii<word.length();ii++) {
			if(arr[i+ii][j]=='-') {
				arr[i+ii][j]=word.charAt(ii);
				wePlaced[ii]=true;
			}
		}
		return wePlaced;		
	}

	
	private static void uplaceWordVertically(char[][] arr, boolean [] wePlace , int i, int j) {
		for(int ii=0;ii<wePlace.length;ii++) {
			if(wePlace[ii])
				arr[i+ii][j]='-';
		}			
	}
	private static void uplaceWordHorizontally(char[][] arr, boolean [] wePlace , int i, int j) {
		for(int jj=0;jj<wePlace.length;jj++) {
			if(wePlace[jj])
				arr[i][j+jj]='-';
		}		
	}

	private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
		boolean wePlaced[] =new boolean[word.length()];
		for(int jj=0;jj<word.length();jj++) {
			if(arr[i][j+jj]=='-') {
				arr[i][j+jj]=word.charAt(jj);
				wePlaced[jj]=true;
			}
		}
		return wePlaced;
	}

	private static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
		if(j-1>0 && arr[i][j-1]!='+') {//if left is there and not + then return false
			return false;
		}else if(j+word.length()<arr[0].length && arr[i][j+word.length()]!='+') { //if there is right and its not +
			return false;

		}
		for(int jj=0;jj<word.length();jj++) { //if there is blank or same char as we want to put
			//if(j+jj>=word.length()) //if out of board 
			if(j+jj>=arr[0].length)
				return false;
			if(arr[i][j+jj]=='-' || arr[i][j+jj]==word.charAt(jj)) //if - is there or same char is laready there 
				continue;
			else return false;
			
		}
		return true;
	}
	private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
		if(i-1>0 && arr[i-1][j]!='+') {//if left is there and not +
			return false;
		}else if(i+word.length()<arr[0].length && arr[i+word.length()][j]!='+') { //if there is right and its not +
			return false;

		}
		for(int ii=0;ii<word.length();ii++) { //if there is blank or same char as we want to put
			if(i+ii>=arr.length)
				return false;
			if(arr[i+ii][j]=='-' || arr[i+ii][j]==word.charAt(ii))
				continue;
			else return false;
			
		}
		return true;
	}
}
