package August_third;

import java.io.*;
import java.util.*;

public class bj_2583_영역구하기_Silver_1 {
	
	static int N;
	static int M;
	static int K;
	static int map[][];
	static boolean visited[][];
	static int cnt;
	static int [][]mov = {{-1,0},{0,1},{1,0},{0,-1}};
	static List<Integer> answerList = new ArrayList<>();
	
	static void bfs(int y,int x) {
		
		visited[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			
			cnt++;
			
			int []c = q.poll();
			int i = c[0];
			int j = c[1];
			
			for(int d = 0 ; d < 4 ; d ++) {
				int ni = i + mov[d][0];
				int nj = j + mov[d][1];
				
				if(ni<0 || nj<0 || N-1 < ni || N-1 < nj) continue;
				
				if(map[ni][nj]==0 && !visited[ni][nj]) {
					visited[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int tc=0;tc<K;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int fj = Integer.parseInt(st.nextToken()); //좌표상
			int fi = N - Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int si = N - Integer.parseInt(st.nextToken());
			
			
			for(int i=fi ; i>=si ; i--) {
				for(int j=fj ; j <=sj ; j++) {
					map[i][j] = 1;
				}
			}
			
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println();
			
		}
		
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					cnt = 0;
					bfs(i,j);
					answerList.add(cnt);
				}
			}
		}
		
		Collections.sort(answerList);
		
		System.out.println(answerList);
		
	}

	
}
