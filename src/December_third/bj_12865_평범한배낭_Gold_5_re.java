package December_third;

import java.util.*;
import java.io.*;

public class bj_12865_평범한배낭_Gold_5_re {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int answer = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
	
		//dp 배열
		int [][] dp;
		
		int [] W = new int[N+1];
		int [] V = new int[N+1];
		
		//input
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
			
		}
		//dp 선언
		dp = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) { //물건 개수만큼 for
			for(int j=1;j<K+1;j++) { //기준이 되는 무게만큼만 for
				dp[i][j] = dp[i-1][j]; //그전꺼 저장
				if(W[i]<=j) { //K까지 가는 j보다 자기 무게가 작다면
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]); 
					//이전에 구한 가치 vs 남은 무게의 가치+지금 물건의 가치  중 큰 값
				}
			}
		}
		
		for(int [] i : dp) System.out.println(Arrays.toString(i));
	
		answer = dp[N][K];
		System.out.println(answer);
		
	}
}
