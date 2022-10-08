package Dijikstra;

import java.util.*;
import java.io.*;

public class bj_5972_택배배송_Gold_5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] ad = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			ad[from][to] = ad[to][from] =  weight;
		}
		int start = 0;
		int end = N-1;
		boolean[] visited = new boolean[N];
		int idx, min;
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for(int i=0;i<N;i++) {
		
			idx = -1;
			min = Integer.MAX_VALUE;
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx==-1) break;
			visited[idx] = true;
			if(visited[end]) break;
			for(int j=0;j<N;j++) {
				if(!visited[j] && ad[idx][j]!=0 && dist[j] > ad[idx][j] + dist[idx] ) {
					dist[j] = ad[idx][j] + dist[idx];
				}
			}
			
			
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(dist[end]);
		
	}
}
