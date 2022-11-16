package November_third;

import java.util.*;
import java.io.*;

public class Solution_4193_수영대회_결승전 {
	
	static int N, map[][];
	static int si,sj,ei,ej;
	static int answer;
	static boolean[][]visited;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int t=1;t<=TC;t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			answer = -1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine()," ");
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()," ");
			ei = Integer.parseInt(st.nextToken());
			ej = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new ArrayDeque<>();
			
			q.offer(new int[] {si,sj,0});
			
			while(!q.isEmpty()) {
				
				int [] c = q.poll();
				
				int i = c[0];
				int j = c[1];
				int cnt = c[2];

				if(i==ei && j==ej) {
					answer = cnt;
					break;
				}
					
				for(int d=0;d<4;d++) {
					
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
					if(map[ni][nj]==1 ||visited[ni][nj]==true) continue;
					
					if(map[ni][nj]==2) {
						if(cnt%3==2) {
							visited[ni][nj] = true;
							q.offer(new int[] {ni,nj,cnt+1});							
						}else {

							q.offer(new int[] {i,j,cnt+1});
						}
					}else {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}
					
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");	
		}
			System.out.println(sb.toString());
	}

}
