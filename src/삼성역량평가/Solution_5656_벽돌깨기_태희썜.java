package 삼성역량평가;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기_태희썜 {
	
	
	static int num;
	static int N,M ,min;
	static int [] permArr;
	static int answer;
	
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//순열 후 터뜨려야겠다.
		
		int tc = Integer.parseInt(br.readLine());
		
		answer = Integer.MIN_VALUE;
		
		for(int t=1;t<=tc;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			num = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
				
			
			int [][] map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#"+tc+" "+min);
		
		}
		
	}
	
	
	static void go(int cnt,int [][]map) {
		
		if(cnt==num) {
			
			// 남은 벽돌 수 카운트, 최솟값 갱신
			int result = getRemain(map);
			if(result<min) min=result;
			return;
		}
		
		
		//구슬 던지기 (중복 순열)
		int [][] newMap = new int[N][M];
		
		
		for(int c=0;c<M;c++) {
			//구슬에 맞는 시작벽돌 찾기
			
			int r= 0;
			
			while(r < N && map[r][c]==0) ++r;
			//시작 벽돌이 없는 경우
			if(r==N) {
				go(cnt+1,map);
			//있는경우
			}else {
				
				copy(map,newMap);
				//제거될 벽돌 연쇄 처리
				boom(newMap,r,c);
				//벽돌 중력 처리	
				down(newMap);
				//다음 구슬 던지기
				go(cnt+1,newMap);
			}
		}
		
		
		
		
	}
	
	
	static int getRemain(int[][] map) {
		
		int result = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]>0) result++;
			}
		}
		
		
		return result;
	}


//	static void down(int[][] map) {
//		
//		for(int c=0;c<M;c++) {
//			int r = N-1;
//			while(r>0) {
//				if(map[r][c]==0) {// 빈칸이면 내릴 벽돌 찾기
//					int nr = r-1;
//					while(nr>0 && map[nr][c]==0) nr--;
//					
//					map[r][c] = map[nr][c];
//					map[nr][c] = 0;
//					
//				}
//				
//				--r;
//			}
//		}
//
//	}
	
	static Stack<Integer> stack = new Stack<Integer>();
	
	static void down(int[][] map) {
		
		
		
		for(int c=0;c<M;c++) {
			
			for(int r=0;r<N;r++) {
				if(map[r][c]>0) {
					stack.push(map[r][c]);
					map[r][c] =0;
				}
			}
			int nr = N-1;
			while(!stack.isEmpty()) {
				map[nr--][c] = stack.pop();
			}
		}
		
		
		
	}


	static void boom(int[][]map,int r,int c) { //BFS
		
		
		Queue<Point> queue = new ArrayDeque<>(); 
		//벽돌이 있던 자리를 0으로 바꿈 : 빈칸으로 만들어서 방문처리
		if(map[r][c]>1) queue.offer(new Point(r,c,map[r][c]));
		//방문처리 ( 제거처리 )
		map[r][c] = 0;
		
		while(!queue.isEmpty()) {
			
			Point p = queue.poll(); //주변에 영향을 줍니다.
			
			//벽돌의 크기 -1만큼 주변 벽돌 연쇄 처리
			for(int d=0;d<4;d++) {
				int nr = p.r;
				int nc = p.c;
				for(int k=1;k<p.cnt;k++) { //cnt -1
					nr += move[d][0];
					nc += move[d][1];
					if(nr<0||nc<0||N-1<nr||M-1<nc) continue;
					if(map[nr][nc]>1) queue.offer(new Point(nr,nc,map[nr][nc]));						
					
					//방문처리 ( 제거처리 ) //0,1일경우 그냥 제거만 하면 됩니다잉?
					map[nr][nc] = 0;
				}
			}
		}
		
		
		
	}
	
	static void copy(int[][]map,int[][]newMap) {
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				newMap[i][j] = map[i][j];
	}

	static class Point{
		
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
}
