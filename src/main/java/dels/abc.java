package dels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
class abc {
	
	
	public static void main(String[] args) {
//		long dp[]=new long[51];
//		Arrays.fill(dp, -1);
//		System.out.print(fib(50,dp));
		
	   //System.out.print(gridTraveler(2,3));
		
//		long  dp[][]=new long[20][20];
//		for(long[]d:dp)
//			Arrays.fill(d, -1);
//		System.out.print(gridTraveler(18,18,dp));
		
//		int a[]= {7,14};
//		HashMap<Integer,Boolean> canSumap=new HashMap<>();
//		System.out.println(canSum(a,300,canSumap));
		
//		int a[]= {5,3,4,7};
//		HashMap<Integer,Boolean> canSumap=new HashMap<>();
//		System.out.println(bestSum(a,7));
		
		
		//String a[]= {"ab","abc","cd","def","abcd","abcdef"};
//		String a[]= {"a","aa","aaa","aaaa","aaaaa","aaaaa"};
//		System.out.println(allConstruct2(a,"aaaaaa",new HashMap<String,List<List<String>>>()));
		//System.out.print(fib3(6));
		
		
//		int a[]= {5,3,4};
//		System.out.println("CANN:- "+bestSum2(a,7));

		/*
		 * String a[]= {"ab","abc","cd","def","abcd","ef","c"};
		 * System.out.println("CANN:- "+allConstruct2(a,"dbcdef"));
		 */

		
	}
	




	private static List<String>  allConstruct2(String[] words, String str) {
		List<List<String>> dp=new ArrayList<>();
		for(int i=0;i<=str.length();i++)
			dp.add(null);
		dp.set(0,new ArrayList<>());
		for(int i=0;i<=str.length();i++) {
			if(dp.get(i)!=null) {
				for(String word:words) {
					int index=i+word.length();
					if(i+word.length()>=(str.length()+1))continue;
					if(str.substring(i,i+word.length()).equals(word)) {
						//dp[i+word.length()]+=dp[i];
						List<String> list=dp.get(i);
						if(list!=null) {
							List<String> newCombination=new ArrayList<>(list);
							newCombination.add(word);
							List<String> existing=dp.get(i+word.length());
							if(existing==null)
								dp.set(i+word.length(), newCombination);
							else existing.addAll(newCombination);
						}
					}
				}
			}
		}
		return dp.get(str.length());
	}



	private static List<Integer> bestSum2(int[] a, int target) {
		List<List<Integer>> dp=new ArrayList<>();
		for(int i=0;i<=target;i++)
			dp.add(null);
		dp.set(0,new ArrayList<Integer>());
		
		for(int i=0;i<=target;i++) {
			if(dp.get(i)!=null) {
				for(int num:a) {
					List<Integer> curr=new ArrayList<>(dp.get(i));
					curr.add(num);
					int index=i+num;
					if(index>target)continue;
					if(dp.get(index)==null 
							|| dp.get(index).size()>curr.size()) {
						dp.set(index,curr);
					}
				}
			}
		}
		System.out.print(dp);
		return dp.get(target);
	}



	private static boolean canSum2(int[] a, int target) {
		int n=a.length;
		boolean table[]=new boolean[target+1];
		table[0]=true;
		for(int i=0;i<table.length;i++) {
			if(table[i]==true) {
				for(int j=0;j<a.length;j++) {
					int num=a[j];
					if(i+num<table.length)
						table[i+num]=true;
				}
			}
		}
		return table[target];
	}

	public static int fib3(int n) {
		int dp[]=new int[n+1];
		dp[1]=1;
		for(int i=0;i<=n;i++) {
			if(i+1<=n)
				dp[i+1]+=dp[i];
			if(i+2<=n)
				dp[i+2]+=dp[i];
		}
		return dp[n];
	}
	


	private static List<List<String>> allConstruct2(String[] a, String target, HashMap<String,List<List<String>>>memo) {
		if(memo.containsKey(target))return memo.get(target);
		if(target.length()==0) {
			List<String> inner=new ArrayList<>();
			List<List<String>> ans=new ArrayList<>();
			ans.add(inner);
			return ans;
			
		}
		List<List<String>> res=new ArrayList<>();
		for(String s:a) {
			if(target.startsWith(s)) {
				String ros=target.substring(s.length());
				List<List<String>> ans=allConstruct2(a, ros,memo);
				for(List<String> l:ans) {
					l.add(s);
					res.add(l);
				} 
			}
		}
		memo.put(target, res);
		return res;
		
	}


	private static void allConstruct(String[] a, String str,ArrayList<String>asf,ArrayList<ArrayList<String>> ans,HashMap<String,ArrayList<String>> memo) {
		if(memo.containsKey(str)) {
			ans.add( memo.get(str));
			return;
		}
		if(str.length()==0) {
			ans.add(new ArrayList<>(asf));
			memo.put(str,new ArrayList<>(asf));
			return ;
		}
		for(String s:a) {
			if(str.startsWith(s)) {
				String ros=str.substring(s.length());
				asf.add(s);
				allConstruct(a, ros,asf,ans,memo);
				asf.remove(asf.size()-1);
			}
		}
	}


	private static ArrayList<Integer> bestSum(int[] a, int target) {
		if(target==0) {
			return new ArrayList<>();
		}
		if(target<0)return null;
		
		ArrayList<Integer> shortest=null;
		for(int i:a) {
			int remainder=target-i;
			ArrayList<Integer> remainderList=bestSum(a,remainder);
				if(remainderList!=null) {
					remainderList.add(i);
					if(shortest==null || remainderList.size()<shortest.size()) {
						shortest=remainderList;
					}
				}
				
					
			
		}
		return shortest;
	}


	private static boolean canSum(int[] a, int target,HashMap<Integer,Boolean> map) {
		if(target==0)return true;
		if(target<0)return false;
		if(map.containsKey(target))return map.get(target);
		for(int i=0;i<a.length;i++) {
			if(target-a[i]>=0) {
				boolean sum= canSum(a,target-a[i],map);
				if(sum) {
					map.put(target-a[i], true);
					return true;
				}
				
			}
		}
		map.put(target, false);
		return false;
	}


	private static long gridTraveler(int i, int j,long[][] dp) {
		if(dp[i][j]!=-1 || dp[j][i]!=-1)return dp[i][j]==-1?dp[j][i]:dp[i][j];
		if(i==1 && j==1) {
			return 1;
			}
		if(i<1 || j<1)return 0;
		return dp[i][j]=dp[j][i]=gridTraveler(i-1,j,dp)+gridTraveler(i,j-1,dp);
	}
	private static long fib(int n,long [] dp) {
		if(n<=2)return 1l;
		if(dp[n]!=-1)return dp[n]; 
		return dp[n]=fib(n-1,dp)+fib(n-2,dp);
	}
	
	
	
	
	

	
}