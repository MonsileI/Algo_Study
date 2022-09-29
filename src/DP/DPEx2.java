package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DPEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int[] dp = new int[N+1];
		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();
		dp[0] = 0;
		dp[1] = Math.min(R, Math.min(G, B));
		
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
		
		System.out.println(Arrays.toString(dp));
		
	}
}
