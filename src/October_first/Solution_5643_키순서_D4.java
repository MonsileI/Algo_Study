package October_first;

import java.util.*;
import java.io.*;

public class Solution_5643_키순서_D4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC= Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC;t++) {
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			boolean [][] adj = new boolean[N+1][N+1];
			
			
			for(int i=0;i<M;i++) {
				StringTokenizer st = new  StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = true;
			}
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
					}
				}
			}
	
			int res = 0;
			label1: for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(!adj[i][j] && !adj[j][i]) continue label1;
				}
				res++;
			}
			
			System.out.println("#"+ t + " " + res);
		}
	}
}