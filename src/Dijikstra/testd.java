package Dijikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class testd {

	static int N;
	static int map[][];
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=tc;t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(""+str.charAt(j));
				}
			}
			
			
			System.out.println("#"+t+" "+dijikstra(0,0));
			
		
		}
	}
	
	static int dijikstra(int startR, int startC) {
		
		int[][]dist = new int[N][N];
		boolean[][]visited= new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j] = INF;
			}
		}
		
		dist[startR][startC] = 0;
		int i=-1,j=-1;
	
		
	
		
		
		while(true) {
			
			int minTime = INF;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(!visited[r][c] && dist[r][c] < minTime) {
						minTime = dist[r][c];
						i = r;
						j = c;
					}
				}
			}
			
			visited[i][j] = true;
			
			if(i==-1) return -1;
			
			if(i==N-1&&j==N-1) return minTime;
			
			
			for(int d=0;d<4;d++) {
				
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
				if(visited[ni][nj]) continue; 
				if(dist[ni][nj] > map[ni][nj] + minTime) {
					dist[ni][nj] = map[ni][nj] + minTime;
				}
				
				
			}
			
			
			
		}
		
		
		
		
		
	}


}