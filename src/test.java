
import java.io.*;
import java.util.*;


class test{
		
		static int N, K;
		static int[][] items;
		static int max;
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		// 물건 당 첫 번째 열에는 물건의 무게를, 두 번째 열에는 물건의 가치를 저장한다.
		items = new int[N][2];
		for (int i = 0; i < N; i++) {
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		int[][]dp = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				
				if(items[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
				}
				
			}
		}
		
		
	}
}