package Dijikstra;

import java.util.*;
import java.io.*;

public class dijikstraTest {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][]ad = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				ad[i][j] = tmp;
			}
		}
		
		
		int start = 0;
		int end = N-1;
		int idx,  min;
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		boolean[]visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			idx = -1;
			min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx==-1) break;
			if(visited[end]) break;
			visited[idx] = true;
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && ad[idx][j]!=0 && dist[j] > dist[idx] + ad[idx][j]) {
					dist[j] = dist[idx] + ad[idx][j];
				}
			}
			
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(dist[end]);
		
	}

}
