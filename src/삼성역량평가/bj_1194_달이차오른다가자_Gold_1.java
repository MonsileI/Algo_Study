package 삼성역량평가;

import java.util.*;
import java.io.*;

public class bj_1194_달이차오른다가자_Gold_1 {

	static int N,M;
	static char [][]map;
	static boolean[][][] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[N][M][64];
		
		int si=0,sj=0;
		
		for(int i=0;i<N;i++) {
			char[]tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='0') {
					si = i;
					sj = j;
				}
			}
		}
		
		System.out.println(bfs(si,sj));
		
	}
	
	static int bfs(int y,int x) {
		
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.offer(new int[] {y,x,0});
		
		while(!q.isEmpty()) {
			
			int []c = q.poll();
			
			int i = c[0];
			int j = c[1];
			int cnt = c[2];
			
			
			
			
			
			
			for(int d=0;d<4;d++) {
				
			}
			
			
		}
		
		
		
		
		
		
		return -1;
		
		
		
	}
}
