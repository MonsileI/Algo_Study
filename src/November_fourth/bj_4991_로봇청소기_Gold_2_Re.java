package November_fourth;

import java.util.*;
import java.io.*;

public class bj_4991_로봇청소기_Gold_2_Re {
	
	static int N,M,ci,cj;
	static char[][] map;
	static List<int[]> list;
	static int size;
	static boolean[][]visited;
	static int[]temp;
	static int answer;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][]dist;
	static boolean flag;
	static boolean pVisited[];
	
	
	static void perm(int idx,int depth,int sum) {

		if(answer<=sum) return;
		
		if(depth==size-1) {
			sum += dist[idx][0];
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=1;i<size;i++) {
			if(!pVisited[i]) {
				pVisited[i] = true;
				int newSum = sum + dist[idx][i];
				perm(i,depth+1,newSum);
				pVisited[i] = false;
			}
		}
	}
	
	
	static void bfs(int idx) {
		
		int [] gc = list.get(idx);
		
		for(int r=idx+1;r<size;r++) {
			visited = new boolean[N][M];
			flag = false;
			Queue<int[]> q= new ArrayDeque<>();
			int []tmp = list.get(r);
			q.offer(new int[] {tmp[0],tmp[1],0});
			visited[tmp[0]][tmp[1]] = true;
			while(!q.isEmpty()) {
				
				int [] c = q.poll();
				int i = c[0];
				int j = c[1];
				int cnt = c[2];
				
				if(i==gc[0] && j==gc[1]) {
					flag = true;
					dist[idx][r] = dist[r][idx] = cnt;
				}
				
				for(int d=0;d<4;d++) {
					
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
					if(!visited[ni][nj] && map[ni][nj]!='x') {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}
				}
				
			}	
			if(!flag) return;
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
			
			map = new char[N][M];
			list = new ArrayList<>();
			int idx = 1;
			list.add(new int[] {0,0});
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='o') {ci = i; cj= j; map[i][j]='.'; list.set(0,new int[] {i,j});}
					else if(map[i][j]=='*') list.add(idx++,new int[] {i,j});
				}
			}	
			size = list.size();
			dist = new int[size][size];
			answer = 987654321;
			for(int i=0;i<size;i++) {
				bfs(i);
				if(!flag) {
					answer = -1;
					break;
				}
			}
			
			
			pVisited = new boolean[size];
			pVisited[0] = true;
			perm(1,0,0);
			
			for(int [] i : dist) System.out.println(Arrays.toString(i));
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

	
}
