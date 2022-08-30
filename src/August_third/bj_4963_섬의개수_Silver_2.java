package August_third;

import java.io.*;
import java.util.*;

public class bj_4963_섬의개수_Silver_2 {
	
	
	static int [][] move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static int N;
	static int M;
	static boolean[][]visited;
	static int[][]map;
	
	static void bfs(int y,int x) {
		
		visited[y][x] = true;
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			
			int []c = q.poll();
			
			int i = c[0];
			int j = c[1];
			
			for(int d=0;d<8;d++) {
				
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				
				
				if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
				
				if(!visited[ni][nj] && map[ni][nj]==1) {
					visited[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
				
				
				
			}
			
			
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			int cnt = 0;
			
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
			
			
		}
		
	}

}
