package November_fourth;

import java.util.*;
import java.io.*;

public class bj_4991_로봇청소기_Gold_2 {
	
	static int N,M,ci,cj;
	static char[][] map;
	static List<int[]> dust;
	static int size;
	static boolean[]visited;
	static int[]temp;
	static int answer;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	static void bfs() {
		
		int sum = 0;
		int ti = ci;
		int tj = cj;
		boolean flag = false;
		
		for(int dd=0;dd<size;dd++) {
			flag= false;
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {ti,tj,0});
			boolean[][]v = new boolean[N][M];
			int gi = dust.get(temp[dd])[0];
			int gj = dust.get(temp[dd])[1];
			v[ti][tj]= true;
			
			while(!q.isEmpty()) {
				
				int [] c = q.poll();
				
				int i = c[0];
				int j = c[1];
				int cnt = c[2];
				
				if(i==gi &&j ==gj) {
					sum += cnt;
					ti = i;
					tj = j;
					flag= true;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
					
					if(!v[ni][nj] && (map[ni][nj]=='.' || map[ni][nj]=='*')){
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}
					
				}
				
			}
			
			if(!flag) return;
			if(answer<=sum) return;
		}
	
		answer = Math.min(answer, sum);
		
	}
	
	static void perm(int depth) {
		
		if(depth==size) {
			
			bfs();
	
			return;
		}
		
		
		for(int i=0;i<size;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				perm(depth+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			answer = 987654321;
			map = new char[N][M];
			dust = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='o') {ci = i; cj= j; map[i][j]='.';}
					else if(map[i][j]=='*') dust.add(new int[] {i,j});
				}
			}	
			size = dust.size();
			visited = new boolean[size];
			temp = new int[size];
			perm(0);
		
			sb.append(answer == 0 ? -1 : answer).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

	
}
