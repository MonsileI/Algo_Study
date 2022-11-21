package November_fourth;

import java.util.*;
import java.io.*;

public class Solution_2112_보호필름_D4 {
	
	static int N,M,K,map[][];
	static int[]visited;
	static int answer;
	static void dfs(int depth,int count) {

		if(answer<=count) return;
		
		if(depth==N) {
			
			boolean flag = false;
			
			for(int j=0;j<M;j++) {
				
				flag = false;
				
				int tmpNum = map[0][j];
				if(visited[0]==1) tmpNum = 1;
				else if(visited[0]==-1) tmpNum = 0;
				
				int tmpCount = 1;
				
				innerLoop:
				for(int i=1;i<N;i++) {
					
					int compNum = map[i][j];
					if(visited[i]==1) compNum = 1;
					else if(visited[i]==-1) compNum = 0;
					
					if(compNum!=tmpNum) {
						tmpNum = compNum;
						tmpCount = 1;
					}else tmpCount++;
					
					if(tmpCount==K) {
						flag = true;
						break innerLoop;
					}
				}
				if(!flag) return;
			}
			
			answer = Math.min(answer, count);
			
			return;
		}
		
		
		visited[depth] = 1;
		dfs(depth+1, count+1);
		visited[depth] = -1;
		dfs(depth+1, count+1);
		visited[depth] = 0;
		dfs(depth+1, count);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			map = new int[N][M];
			visited = new int[N];
			for(int i=0;i<N;i++) {				
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken());			
			}
			
			dfs(0,0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
