package DP;

import java.util.*;
import java.io.*;

public class Solution_1263_사람네트워크2 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			
			int [][] dist = new int[N][N];
			
			for(int i =0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && dist[i][j]==0) dist[i][j] = 987654321;
				}
			}
			
			for(int k=0;k<N;++k) {
				for(int i=0;i<N;++i) {
					for(int j=0;j<N;++j) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[j][k]);
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				int sum =0;
				for(int j=0;j<N;j++) {
					sum += dist[i][j];
				}
				
				answer = Math.min(answer, sum);
			}
			
			System.out.println("#"+t+" "+ answer);
			
		}
		
	}

}
