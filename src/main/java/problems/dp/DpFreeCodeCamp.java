package problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=224s
public class DpFreeCodeCamp {
	// Memorization
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static HashMap<String, Integer> map2 = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub 102334155
		long start = System.currentTimeMillis();
		System.out.println(fib3(30));
		//System.out.println("Grid travler :-" + gridTraveler(4, 4));
		long end = System.currentTimeMillis();
		System.out.println("total time :-" + (end - start));

		//System.out.println("Grid travler :-" + gridTraveler1(3, 3));// how many way to travel grid with down and right
																	// move only 4924
		int a[]= {2,3,5};
		System.out.print("CAN SUM:-"+howSum(8,a));
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
		a[2] = 1;

		for (int i = 3; i <= n; i++) {
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
		int dp[][]=new int [n+1][t+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<t+1;j++) {
				if(i==0)
					dp[i][j]=Integer.MAX_VALUE-1;
				if(j==0)
					dp[i][j]=0;
				
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<t+1;j++) {
				if(a[i-1]<=j) {
					dp[i][j]=Math.min(1+dp[i][j-a[i-1]], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		List<Integer> list=new ArrayList<>();
		for(int i:dp[n])
			list.add(i);
		return list;
		
	}
	
	public boolean canConstruct(String target,ArrayList<String> list) {
		if (target.length()==0)return true;
		return false ;
		
	}

}
