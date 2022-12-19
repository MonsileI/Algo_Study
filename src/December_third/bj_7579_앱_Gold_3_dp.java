package December_third;

import java.io.*;
import java.util.*;

public class bj_7579_앱_Gold_3_dp {
	
	static int N,M,cost[],memory[],dp[],sum,answer;
	
	public static void main(String [] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N];
		cost = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) memory[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		dp = new int[sum+1];
		
		for(int i=0;i<N;i++) {
			for(int j=sum;j>=cost[i];j--) {
				dp[j] = Math.max(dp[j], dp[j-cost[i]]+memory[i]);
			}
		}
		
		for(int i=0;i<=sum;i++) {
			if(M<=dp[i]) { 
				answer = i; 
				break;
				}
		}
		
		
		System.out.println(answer);
		
	}
}