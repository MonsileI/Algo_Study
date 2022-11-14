package November_second;
import java.util.*;
import java.io.*;

public class bj_17485_진우의달여행_Gold_5 {
	
	static int N,M,map[][],answer;

	
	
	static void dfs(int i,int j,int sum,int d) {
		
	
		
		if(i==N-1) {
			answer = Math.min(answer, sum);
			return;
		}
		
		int newSum = sum;
		if(0<j && j < M-2) {
			if(d==-1) {
				dfs(i+1,j,newSum+map[i+1][j],0);
				dfs(i+1,j+1,newSum+map[i+1][j+1],1);
			}else if(d==0) {
				dfs(i+1,j-1,newSum+map[i+1][j-1],-1);
				dfs(i+1,j+1,newSum+map[i+1][j+1],1);
			}else {
				dfs(i+1,j,newSum+map[i+1][j],0);
				dfs(i+1,j-1,newSum+map[i+1][j-1],-1);
			}
		}else if(j==0) {
			if(d==0) dfs(i+1,j+1,newSum+map[i+1][j+1],1);
			else dfs(i+1,j,newSum+map[i+1][j],0);
		}else {
			if(d==0) dfs(i+1,j-1,newSum+map[i+1][j-1],-1);
			else dfs(i+1,j,newSum+map[i+1][j],0);
		}
	
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		answer = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			dfs(i,0,map[i][0],-1);
			dfs(i,0,map[i][0],0);
			dfs(i,0,map[i][0],1);
		}
		
		
		System.out.println(answer);
	}
}
