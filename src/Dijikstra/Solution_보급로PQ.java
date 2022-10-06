package Dijikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_보급로PQ {

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
			
			int answer = Integer.MAX_VALUE/2;
			
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
		
		//int[] : r,c,minTime
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[2] - o2[2];
			}
		});
		
		
		// 1단계 출발지에서 자신으로의 최소비용을 저장할 배열 생성 ( INF로 초기화 )
		
		int[][] minCost = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				minCost[i][j] = INF;
		
		
		//출발지에서 출발지로의 최소비용 0처리
		minCost[startR][startC] = 0;
		int r=-1,c=-1,nr,nc,minTime;
		
		pq.offer(new int[] {startR,startC,minCost[startR][startC]});
		while(!pq.isEmpty()) {
			
			// step 1.미방문정점중 최소비용 정점 찾기.
		
			int[]current = pq.poll();
			
			r = current[0];
			c = current[1];
			minTime = current[2];
			
			if(visited[r][c]) continue;
			
			visited[r][c] = true;
			if(r==N-1 && c==N-1) return minTime;
			
			
			
			
			// step 2. 현재 정점 기준으로 인접한 정점들 들여다보며 경유비용이 유리한지 계산
			
			for(int d=0;d<4;d++) {
				
				nr = r + move[d][0];
				nc = c + move[d][1];
				
				if(nr<0||nc<0||N-1<nr||N-1<nc) continue;
				if(visited[nr][nc]) continue;
				if(minCost[nr][nc] < minTime + map[nr][nc]) continue;
				minCost[nr][nc] = minTime + map[nr][nc];
				pq.offer(new int[] {nr,nc,minCost[nr][nc]});
				
				
			}

			
			
		}
		
		
		
		return -1;
		
		
	}


}