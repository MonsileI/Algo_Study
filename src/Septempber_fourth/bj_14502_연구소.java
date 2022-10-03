package Septempber_fourth;

import java.io.*;
import java.util.*;

public class bj_14502_연구소 {

	static int N,M;
	static int[][]map;
	static List<int[]> zList = new ArrayList<>();
	static List<int[]> vList = new ArrayList<>();
	static int[][]tmp;
	static int answer;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zList.add(new int[] {i,j});
				if(map[i][j]==2) vList.add(new int[] {i,j});
			}
		}
		
		
		//콤비네이션 벽 3개 세우기
		tmp = new int[3][2];
		combi(0,0);

		System.out.println(answer);
	
	}
	
	static void calc() {
		
		int [][] m = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				m[i][j] = map[i][j];
			}
		}
		
		m[tmp[0][0]][tmp[0][1]] = 1;
		m[tmp[1][0]][tmp[1][1]] = 1;
		m[tmp[2][0]][tmp[2][1]] = 1;
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int []i : vList) q.offer(new int [] {i[0],i[1]});
		
		
		while(!q.isEmpty()) {
			
			int []c = q.poll();
			int i = c[0];
			int j = c[1];
			
			for(int d=0;d<4;d++) {
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				
				if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
				if(m[ni][nj]!=0) continue;
				
			}
			
			
		}
		
		
		
		
	}
	
	static void combi(int start,int depth) {
		
		if(depth==3) {
			calc();
			return;
		}
		
		
		for(int i=start;i<zList.size();i++) {
			tmp[depth] = zList.get(i);
			combi(i+1,depth+1);
		}
		
		
		
	}
	
}
