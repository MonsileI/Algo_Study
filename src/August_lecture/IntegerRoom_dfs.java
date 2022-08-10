package August_lecture;


import java.io.*;
import java.util.*;

public class IntegerRoom_dfs {

	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int [][] map;
	static int n;
	static int maxRoom;
	static int maxMove;
	static boolean[][] visited;
	
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
			maxRoom =0;
			maxMove =0;
	
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dfs(i,j,1,map[i][j]);
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(maxRoom).append(" ").append(maxMove);
			
			System.out.println(sb.toString());
			
		}
		
	}
	
	static void dfs(int i, int j , int cnt,int start) {
		
		
		if(maxMove<cnt) {
			maxMove = cnt;
			maxRoom = start;
		}else if(maxMove==cnt) {
			maxRoom = Math.min(maxRoom, start);
		}
		
		for(int d =0; d<4; d++) {
			
			int ni = i + move[d][0];
			int nj = j + move[d][1];
			
			if(ni<0 || nj<0 || n-1 < ni || n-1 < nj) continue;
		
			if(map[i][j]+1 != map[ni][nj]) continue;
			
			dfs(ni,nj,cnt+1,start);
			
			
			
			
		}
		
	
	
	}
	
		
}