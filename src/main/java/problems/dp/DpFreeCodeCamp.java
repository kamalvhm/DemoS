package problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=224s
public class DpFreeCodeCamp {
	// Memorization
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static HashMap<String, Integer> map2 = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub 102334155
		long start = System.currentTimeMillis();
		System.out.println(fib2(30));
		//System.out.println("Grid travler :-" + gridTraveler(4, 4));
		long end = System.currentTimeMillis();
		System.out.println("total time :-" + (end - start));

		//System.out.println("Grid travler :-" + gridTraveler1(3, 3));// how many way to travel grid with down and right
																	// move only 4924
		int a[]= {2,3,5};
		System.out.println("How SUM--->>"+ howSum(7,a));
		
		ArrayList<String> list=new ArrayList<>();
		list.add("purp");
		list.add("p");
		list.add("ur");
		list.add("le");
		list.add("purpl");
		
		System.out.print("CAN SUM:-"+allConstruct("purple",list));
	}
	
	public static boolean canSUM(int sum,int a[]) {
		int n=a.length;
		boolean t[][]=new boolean [n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j]=false;
				if(j==0)
					t[i][j]=true;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(a[i-1]<=j) {
					t[i][j]=t[i-1][j-a[i-1]] || t[i-1][j];
				}else 
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
	}

	private static int fib(int n) {
		if (n <= 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	private static int fib2(int n) {
		int[] a = new int[n + 1];
		a[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n];
	}

	private static int fib3(int n) {
		if (map.containsKey(n))
			return map.get(n);
		if (n <= 2)
			return 1;
		else {
			int i = fib(n - 1) + fib(n - 2);
			map.put(n, i);
			return i;
		}
	}

	public static int gridTraveler(int a, int b) {
		
		if (a == 0 || b == 0)
			return 0;
		if (a == 1 && b == 1)
			return 1;
		
		return gridTraveler(a - 1, b) + gridTraveler(a, b - 1);

	}
	//64. Minimum Path Sum  VARIATION CHECK CODE ONLINE 
	public static int gridTraveler1(int a, int b) {
		String key=a+"-"+b;
		if(map2.containsKey(key))return map2.get(key);
		if (a == 0 || b == 0)
			return 0;
		if (a == 1 && b == 1)
			return 1;
		map2.put(key, gridTraveler(a - 1, b) + gridTraveler(a, b - 1));
		return map2.get(key);

	}
//63. Unique Paths II | https://leetcode.com/problems/unique-paths-ii/
	public static int gridTraveler2(int a, int b) {
		int dp[][] = new int[a + 1][b + 1];

		for (int i = 1; i < a + 1; i++) {
			for (int j = 1; j < b + 1; j++) {
				if (i == 1 || j == 1) {
					dp[i][j]=1;
				} else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			}
		}
		return dp[a][b];
	}
	
	public static List<Integer>  howSum(int t,int [] a) {
		int n =a.length;
		List<List<Integer>> dp=new ArrayList<>(t+1);
		
		dp.add(0, new ArrayList<>()); //adding empty [] array at 0 as 0 sum is possible without any values
		for(int i=1;i<=t;i++) {
			dp.add(i,null);
		}
		for(int i=0;i<=t;i++) {
			if(dp.get(i)!=null) {//if currant pos in not null then we can generate next ammounts 
				for(int num:a) {
					List<Integer> currntPosList=dp.get(i);
					currntPosList.add(num); //adding num in current position and putting it to next pos 
					if((i+num)>(t+1))break;
					dp.add((i+num),currntPosList);
				}
			} 
			
		}
		
		return dp.get(t);
		
	}
	//139. Word Break | https://leetcode.com/problems/word-break/
	public boolean canConstruct(String target,ArrayList<String> list) {
		if (target.length()==0)return true;
		return false ;
		
	}
	
	public static int countConstruct(String target,ArrayList<String> list) {
		if(map2.containsKey(target))return map2.get(target);
		if (target.length()==0)return 1;
		int totalcount=0;
		for(String s:list) {
			if(target.startsWith(s)) {
				int numWaysForReast=countConstruct(target.replace(s, ""),list);
				totalcount+=numWaysForReast;
			}
		}
		map2.put(target, totalcount);
		return totalcount;
	}
	
	public static List<List<String>> allConstruct(String target,ArrayList<String> list) {
		if (target.length()==0) {
			List<String> l=new ArrayList();
			l.add("");
			 List<List<String>> l2=new ArrayList<>();
			 l2.add(l);
			return l2;
		}
		List<List<String>> result=new ArrayList<>();
		for(String s:list) {
			if(target.startsWith(s)) {
				String suffix=target.replace(s, "");
				List<List<String>> suffixWays=allConstruct(suffix,list);
				List<List<String>> suffi=new ArrayList<>();
				for(List<String> l: suffixWays) {
					l.add(0,suffix);
					suffi.add(l);
				}
					
				
				result.addAll(suffi);
				
			}
		}
		return result;
	}


}
