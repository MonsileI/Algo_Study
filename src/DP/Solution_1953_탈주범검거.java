package DP;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거 {
	

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,R,C,L;
	static int[][]map;
	static int answer;
	static boolean[][]visited;
	static int[][]move = {{},{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	
	static void input() throws Exception {
		
		answer = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 L = Integer.parseInt(st.nextToken());
		 map  = new int[N][M];
		 visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	static void output(int t) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("#").append(t).append(" ").append(answer);
		
		System.out.println(sb.toString());
		
		
		
	}
	
	
	static void calc() {
		
		//갈 수 있는지 없는지 먼저 판단해보자!
		//bfs해서 갈수 있나 없나 확인하면 되는거 아님? ;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		visited[R][C] = true;
		
		q.offer(new int[] {R,C,L-1});
		
		
		while(!q.isEmpty()) {
			
			int []cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			int cnt = cur[2];
			
			
			
			int status = map[i][j];
			boolean[] path = new boolean[5];
			//상 하 좌 우 1 2 3 4   
			//상 하 1 2           
			//좌 우 3 4           
			//상 우 1 4
			//하 우 2 4
			//하 좌 2 3
			//상 좌 1 3
			switch (map[i][j]) {
			case 1: break;
			
			case 2: path[3] = true;
					path[4] = true; 
					break;
			case 3: path[1] = true;
					path[2] = true; 
					break;
			case 4: path[2] = true;
					path[3] = true; 
					break;
			case 5: path[1] = true;
					path[3] = true; 
					break;
			case 6: path[1] = true;
					path[4] = true; 
					break;
			case 7: path[2] = true;
					path[4] = true; 
					break;
			
			}
			
			
			/*
			 상 -> 1,2,5,6	
			하 -> 1,2,4,7
			좌 -> 1,3,4,5
			우 -> 1,3,6,7
			 * */
			for(int d=1;d<5;d++) {
				
				//계산 안해~
				if(path[d]==true) continue;
				
				
				int ni = i + move[d][0]; 
				int nj = j + move[d][1];
				
				if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
				
				if(cnt<=0) continue;	
				int ns = map[ni][nj];
				if(ns==0) continue;
				
				if(d==1) if(ns==3||ns==4||ns==7) continue;
				if(d==2) if(ns==3||ns==5||ns==6) continue;
				if(d==3) if(ns==2||ns==6||ns==7) continue;
				if(d==4) if(ns==2||ns==4||ns==5) continue;
				
				if(visited[ni][nj]) continue;
				
				visited[ni][nj] = true;
				q.offer(new int[] {ni,nj,cnt-1});
				answer++;
				
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		
		int Test_Case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=Test_Case;t++) {
			
			input();
			calc();
			output(t);
			
		
			
		}
		
		
	}

	
}
