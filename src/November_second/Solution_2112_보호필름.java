package November_second;

import java.util.*;
import java.io.*;

public class Solution_2112_보호필름 {

	static int N,M,K,map[][];
	static int answer;
	static int[]visited;
	
	static void calc(int sum) {
		
		
		boolean flag = false;

		for(int j=0;j<M;j++) {
			
			flag = false;
			
			int checkNum = 0;
			
			if(visited[0]==0) checkNum = map[0][j];
			else if(visited[0]==1) checkNum = 1;
			else checkNum = 0;
			
			int checkCnt = 1;
			
			
			for(int i=1;i<N;i++) {
				int tmpNum = 0;
				
				if(visited[i]==0) tmpNum = map[i][j];
				else if(visited[i]==1) tmpNum = 1;
				else tmpNum = 0;

				if(checkNum != tmpNum) {
					checkCnt = 1;
					checkNum = tmpNum;
				}else checkCnt++;
				
				if(checkCnt==K) {
					flag= true;
					break;
				}
				
			}
			
			if(!flag) return;
			
		}
	
			answer = Math.min(answer, sum);
			return;
		
		
	}
	
	
	static void sub(int depth,int sum) {
		
		
		if(answer<=sum) return;
		
		if(depth==N) {
			calc(sum);
			return;
		}
		
		
		visited[depth] = 0;
		sub(depth+1,sum);
		visited[depth] = 1;
		sub(depth+1,sum+1);
		visited[depth] = -1;
		sub(depth+1,sum+1);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N];
			answer = 987654321;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sub(0,0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
