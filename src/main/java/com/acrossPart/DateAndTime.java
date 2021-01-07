package com.acrossPart;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;

public class DateAndTime {

	public static void main(String[] args) {
		int n[]={3,1,5,8};
		maxCoins(n);
		ZonedDateTime fromZdt = ZonedDateTime.parse("2016-01-05T08:20:10+05:30[Asia/Kolkata]");
		//last days of months
		LocalDate lastDayofMonthGivenDate = fromZdt.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
		if((fromZdt.toLocalDate().equals(lastDayofMonthGivenDate) || fromZdt.toLocalDate().equals(lastDayofMonthGivenDate.minusDays(1)) ||
				fromZdt.toLocalDate().equals(lastDayofMonthGivenDate.minusDays(2)))) {
			
		}
		//conversion from zoned to date 
        Date cdate = Date.from(fromZdt.withZoneSameLocal(ZoneId.systemDefault()).toInstant());

	}

	
	public static int maxCoins(int[] nums) {
		int n = nums.length;
		int coinsNew[] = new int[n + 2];
		// add 1 to begining and end of the array
		// Arrays.fill(coinsNew, 1);
		coinsNew[0] = coinsNew[n + 1] = 1;
		int index = 1;
		for (int coin : nums)
			coinsNew[index++] = coin;

		n = coinsNew.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int[] d : dp)
			Arrays.fill(d, -1);

		return solve(coinsNew, 1, coinsNew.length - 1, dp);
	}

	public static int solve(int[] nums, int i, int j, int dp[][]) {
		if (i >= j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int ans = Integer.MIN_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(nums, i, k, dp) + solve(nums, k + 1, j, dp) + nums[i - 1] * nums[k] * nums[j]; //considering kth will burst in last so adjacent will be i-1 and j
			ans = Math.max(ans, temp);
		}
		return dp[i][j] = ans;
	}
}
