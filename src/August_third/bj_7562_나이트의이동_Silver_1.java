package August_third;

import java.io.*;
import java.util.*;

public class bj_7562_나이트의이동_Silver_1 {
	
	//나이트가 이동 (길찾기 문제)
	//나이트는 특정하게 움직입니다~
	//bfs로 풀어봅시다~
	
	static int[][]mov = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	static int N;
	static int y,x;
	static int ty,tx;
	static int[][]map;
	static int[][]tmp;
	static int answer;
	
	static void bfs(int y,int x) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int [] c = q.poll();
			int i = c[0];
			int j = c[1];
			
			if(i==ty && j==tx) {
				answer = Math.min(answer, tmp[i][j]);
				break;
			}
			
			for(int d=0;d<8;d++) {
				int ni = i + mov[d][0];
				int nj = j + mov[d][1];
				
				if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
				
				if(tmp[ni][nj]==0) {
					tmp[ni][nj] = tmp[i][j] +1;
					q.offer(new int[] {ni,nj});
				}
			}
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();

		for(int tc = 0 ; tc < test_case ; tc++) {
			
			answer = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			tmp = new int[N][N];
			
			
			st = new StringTokenizer(br.readLine()," ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			
			ty = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			
			bfs(y,x);
			
			sb.append(answer).append("\n");
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(tmp[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		System.out.println(sb.toString());
		
	}
	

}
