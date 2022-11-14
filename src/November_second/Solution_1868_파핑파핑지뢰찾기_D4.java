package November_second;

import java.util.*;
import java.io.*;

public class Solution_1868_파핑파핑지뢰찾기_D4 {

	static int N;
	static boolean[][]visited;
	static char[][]map;
	static int answer;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1},{-1,1},{1,-1},{-1,-1},{1,1}};
	
	static void bfs(int y,int x) {
		
		visited[y][x] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			
			int[]c = q.poll();
			int i = c[0];
			int j = c[1];

			boolean flag = true;
			
			for(int d=0;d<8;d++) {
				
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				
				if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
				
				if(map[ni][nj]=='*') {
					flag = true;
					continue;
				}
				if(map[ni][nj]=='.') q.offer(new int[] {ni,nj});
				
				
			}
			
			if(flag) {
				map[i][j] = 'C';
				for(int d=0;d<8;d++) {
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
					visited[ni][nj] = true;
					map[ni][nj] = 'C';
					q.offer(new int[] {ni,nj});
					
				}
			}
			
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(); 

		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			visited = new boolean[N][N];
			answer = 0;
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]=='.') {
						answer++;
						bfs(i,j);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='.') answer++;
				}
			}
			for(char ch[] : map)System.out.println(Arrays.toString(ch));
			System.out.println(answer);
		}
	}
}
