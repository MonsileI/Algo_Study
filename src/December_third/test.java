package December_third;

import java.util.*;
import java.io.*;

public class test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int []W = new int[N+1];
		int []V = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		int[][]dp = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				dp[i][j] = dp[i-1][j];
				if(W[i]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
