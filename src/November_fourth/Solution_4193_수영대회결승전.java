package November_fourth;

import java.io.*;
import java.util.*;

public class Solution_4193_수영대회결승전 {

	static int N,si,sj,gi,gj,map[][];
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int answer;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			
			N = Integer.parseInt(br.readLine());
			answer =  -1;
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {				
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine()," ");
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			gi = Integer.parseInt(st.nextToken());
			gj = Integer.parseInt(st.nextToken());
			
			
			Queue<int[]> q = new ArrayDeque<>();
			
			q.offer(new int[] {si,sj,0});
			
			while(!q.isEmpty()) {
				
				int []c = q.poll();
				
				int i = c[0];
				int j = c[1];
				int cnt = c[2];
				
				if(i==gi && j==gj) {
					answer = cnt;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
					
					if(map[ni][nj]==1) continue;
					
					if(!visited[ni][nj] && map[ni][nj]==0) {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}
					if(!visited[ni][nj] && map[ni][nj]==2) {
						
						if(cnt%3==2) {
							visited[ni][nj] = true;
							q.offer(new int[] {ni,nj,cnt+1});
						}else {
							q.offer(new int[] {i,j,cnt+1});
						}
					}
					
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		
		System.out.println(sb.toString());
	
	}
}
