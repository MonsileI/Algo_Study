package August_lecture;


import java.io.*;
import java.util.*;

public class IntegerRoom_bfs {

	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int [][] map;
	static int n;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
		
			StringBuilder sb = new StringBuilder();
			
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = new int[]{0,0};
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					bfs(i,j,1,map[i][j]);
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer[0]).append(" ").append(answer[1]);
			
			System.out.println(sb.toString());
			
		}
		
	}
	
	static void bfs(int i, int j , int cnt,int start) {
	
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {i,j,cnt,start});
		
		while(!q.isEmpty()) {
			
			int[]c = q.poll();
			
			i = c[0];
			j = c[1];
			cnt = c[2];
			start = c[3];
			
			if(cnt>answer[1]) {
				answer[1] = cnt;
				answer[0] = start;
			}else if(cnt==answer[1]) {
				if(answer[0]>start) {
					answer[0]= start;
				}
			}
			
			
			
			for(int d =0; d<4; d++) {
				
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				
				if(ni<0 || nj<0 || n-1 < ni || n-1 < nj) continue;
				
				if(map[i][j]+1 != map[ni][nj]) continue;
				
				q.offer(new int[] {ni,nj,cnt+1,start});
				
				
			}
			
		
			
		}
		
		
		
	}
	
		
}