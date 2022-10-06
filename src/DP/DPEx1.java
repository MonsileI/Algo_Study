package DP;

import java.util.Arrays;

public class DPEx1 {

	public static void main(String[] args) {
		
		int N=8;
		int[] dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 2;
		
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(Arrays.toString(dp));
		
	}
}
