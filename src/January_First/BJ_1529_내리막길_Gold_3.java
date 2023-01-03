package January_First;

import java.util.*;
import java.io.*;

public class BJ_1529_내리막길_Gold_3 {

	static int N,M ,map [][] , dp[][];
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	static int dfs(int i,int j) {
		
		if(i==N-1 && j==M-1) return 1;
		
		if(dp[i][j] != -1) return dp[i][j];
		
		dp[i][j] = 0;
		
		for(int d=0;d<4;d++) {
			
			int ni = i + move[d][0];
			int nj = j + move[d][1];
			
			if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
			
			if(map[i][j] > map[ni][nj]) dp[i][j] += dfs(ni,nj);
			
			
		}
		
		return dp[i][j];
		
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		4 5
		50 45 37 32 30
		35 50 40 20 25
		30 30 25 17 28
		27 24 22 15 10 
		 * */
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; dp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
		int answer = dfs(0,0);
		for(int [] i : dp) System.out.println(Arrays.toString(i));
		System.out.println(answer);
		
	}
}
